package io.swagger.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import org.threeten.bp.OffsetDateTime;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.HashMap;

import io.swagger.model.Graphic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service("GraphicService")
public class GraphicServiceImpl implements GraphicService {

    private static final Logger log = LoggerFactory.getLogger(GraphicServiceImpl.class);

    private static Map<Long, Graphic> graphics;
    static {
        log.info("Init static");
        graphics = new HashMap<>();

        Graphic graphic = new Graphic();
        graphic.setId(1L);
        graphic.setMagnitude(0L);
        graphic.setData("{}");
        graphic.setStartDate(OffsetDateTime.now());
        graphic.setEndDate(OffsetDateTime.now());

        graphics.put(graphic.getId(), graphic);
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

        return graphic;
	}

	@Override
	public byte[] generatePdf(Long id) {
        log.info("generatePdf: " + id);
		return null;
	}

	@Override
	public byte[] generatePng(Long id) {
        log.info("generatePng: " + id);

        File file = new File("/resources/image.png");
        byte[] fileContent = null;
		try {
			fileContent = Files.readAllBytes(file.toPath());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return fileContent;
	}

	@Override
	public boolean sendEmail(Long id) {
        log.info("sendEmail: " + id);
		return true;
	}

}