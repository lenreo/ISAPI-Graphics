package io.swagger.service;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.threeten.bp.OffsetDateTime;

import io.swagger.model.Graphic;

@Service("GraphicService")
public class GraphicServiceImpl implements GraphicService {

    private static final Logger log = LoggerFactory.getLogger(GraphicServiceImpl.class);

    private static final Long PULSO = 0L;
    private static final Long OXIGENO = 1L;
    private static final Long GPS = 3L;

    private static Map<Long, Graphic> graphics;
    static {
        log.info("Init static");
        graphics = new HashMap<>();
        
        final String dataOxigen = "[{\"timestamp\": \"2019-01-01T00:00:00Z\",\"value\": 80},{\"timestamp\": \"2019-01-01T00:00:01Z\",\"value\": 83},{\"timestamp\": \"2019-01-01T00:00:02Z\",\"value\": 89},{\"timestamp\": \"2019-01-01T00:00:03Z\",\"value\": 93},{\"timestamp\": \"2019-01-01T00:00:04Z\",\"value\": 95},{\"timestamp\": \"2019-01-01T00:00:05Z\",\"value\": 95},{\"timestamp\": \"2019-01-01T00:00:06Z\",\"value\": 93}]";
        final String dataBpm = "[{\"timestamp\": \"2019-01-01T00:00:00Z\",\"value\": 90},{\"timestamp\": \"2019-01-01T00:00:01Z\",\"value\": 93},{\"timestamp\": \"2019-01-01T00:00:02Z\",\"value\": 79},{\"timestamp\": \"2019-01-01T00:00:03Z\",\"value\": 90},{\"timestamp\": \"2019-01-01T00:00:04Z\",\"value\": 91},{\"timestamp\": \"2019-01-01T00:00:05Z\",\"value\": 99},{\"timestamp\": \"2019-01-01T00:00:06Z\",\"value\": 92}]";

        Graphic graphicO = new Graphic();
        graphicO.setId(1L);
        graphicO.setMagnitude(OXIGENO);
        graphicO.setData(dataOxigen);
        graphicO.setStartDate(OffsetDateTime.now());
        graphicO.setEndDate(OffsetDateTime.now());

        Graphic graphicB = new Graphic();
        graphicB.setId(2L);
        graphicB.setMagnitude(PULSO);
        graphicB.setData(dataBpm);
        graphicB.setStartDate(OffsetDateTime.now());
        graphicB.setEndDate(OffsetDateTime.now());

        graphics.put(graphicO.getId(), graphicO);
        graphics.put(graphicB.getId(), graphicB);
    }

    private Long generateId() {
        return Long.valueOf(graphics.size() + 1);
    }
    @Override
    public Long add(Graphic graphic) {
        log.info("add: " + graphic.toString());

        if (null == graphic.getId()) {
            Long id = generateId();
            graphic.setId(id);
        }
        graphics.put(graphic.getId(), graphic);
        return graphic.getId();
    }

	@Override
	public boolean check(Graphic graphic) {
        log.info("check: " + graphic.toString());
		return (null != graphic.getData() && !graphic.getData().isEmpty());
	}

	@Override
	public boolean update(Graphic graphic) {
        log.info("update: " + graphic.toString());
        boolean result = false;
        if (graphics.containsKey(graphic.getId())) {
            result = graphic.getId().equals(add(graphic));
        }
        return result;
	}

	@Override
	public Graphic getById(Long id) {
        log.info("getById: " + id);
        return graphics.get(id);
	}

	@Override
	public boolean deleteById(Long id) {
        log.info("deteleById: " + id);
        boolean result = false;
        if (graphics.containsKey(id)) {
            result = (graphics.remove(id) != null);
        }
        return result;
	}

	@Override
	public List<Graphic> findByMagnitude(Long magnitude) {
        log.info("findByMagnitude: " + magnitude.toString());
        List<Graphic> listGraphics = new ArrayList<>();

        graphics.forEach((k, v) -> {
            if (magnitude.equals(v.getMagnitude())) {
                listGraphics.add(v);
            }
        });

        return listGraphics;
    }

	@Override
	public Graphic generate(Long magnitude, OffsetDateTime startDate, OffsetDateTime endDate) {
        log.info("generate: " + magnitude.toString() + " " + startDate + " " + endDate);
        Graphic graphic = new Graphic();
        
        // TODO Leer de medidas

        return graphic;
	}

	@Override
	public byte[] generatePdf(Long id) {
        log.info("generatePdf: " + id);
	    byte[] buffer = null;
		try {
			final InputStream in = getClass().getResourceAsStream("/docs/graphic.pdf");
			buffer = IOUtils.toByteArray(in);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return buffer;
	}

	@Override
	public byte[] generatePng(Long id) {
        log.info("generatePng: " + id);

	    byte[] buffer = null;
		try {
			final InputStream in = getClass().getResourceAsStream("/images/image.png");
			buffer = IOUtils.toByteArray(in);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return buffer;
	}

	@Override
	public boolean sendEmail(Long id) {
        log.info("sendEmail: " + id);
        
        final String username = "";
        final String password = "";

//        Properties prop = new Properties();
//		prop.put("mail.smtp.host", "smtp.gmail.com");
//        prop.put("mail.smtp.port", "587");
//        prop.put("mail.smtp.auth", "true");
//        prop.put("mail.smtp.starttls.enable", "true"); //TLS
        
        Properties prop = new Properties();
		prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "465");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.socketFactory.port", "465");
        prop.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        
        Session session = Session.getInstance(prop,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });
        
        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(username));
            message.setSubject("Enviando gráfica por email");
            message.setText("Gráfica: " + graphics.get(id));
            
            Transport.send(message);

        } catch (MessagingException e) {
            e.printStackTrace();
        }
        
		return true;
	}

}