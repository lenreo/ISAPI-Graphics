package io.swagger.api;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.threeten.bp.OffsetDateTime;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.swagger.annotations.ApiParam;
import io.swagger.model.Graphic;
import io.swagger.service.GraphicService;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2019-11-21T19:15:10.264Z[GMT]")
@Controller
public class GraphicsApiController implements GraphicsApi {

    private static final Logger log = LoggerFactory.getLogger(GraphicsApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @Autowired
    private GraphicService graphicService;

    @org.springframework.beans.factory.annotation.Autowired
    public GraphicsApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<Long> addGraphic(@ApiParam(value = "Gráfica" ,required=true )  @Valid @RequestBody Graphic body) {

        log.info("addGraphic");

        if (graphicService.check(body)) {
            Long id = graphicService.add(body);
            if (null != id) {
                return new ResponseEntity<Long>(id, HttpStatus.OK);
            }
            return new ResponseEntity<Long>(HttpStatus.FORBIDDEN);
        }
        else {
            return new ResponseEntity<Long>(HttpStatus.FORBIDDEN);
        }
    }

    public ResponseEntity<Void> deleteGraphicById(@ApiParam(value = "ID de la gráfica",required=true) @PathVariable("id") Long id) {
        log.info("deleteGraphicById");

        boolean result = graphicService.deleteById(id);
        if (result) {
            return new ResponseEntity<Void>(HttpStatus.OK);
        }
        else {
            return new ResponseEntity<Void>(HttpStatus.FORBIDDEN);
        }
    }

    public ResponseEntity<List<Graphic>> findGraphicByMagnitude(@NotNull @ApiParam(value = "Magnitud de las medidas", required = true) @Valid @RequestParam(value = "magnitude", required = true) Long magnitude) {
        log.info("findGraphicByMagnitude");

        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            List<Graphic> listGraphic = graphicService.findByMagnitude(magnitude);
            return new ResponseEntity<List<Graphic>>(listGraphic, HttpStatus.OK);
        }

        return new ResponseEntity<List<Graphic>>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Graphic> generate(@NotNull @ApiParam(value = "Magnitud de las medidas", required = true) @Valid @RequestParam(value = "magnitude", required = true) Long magnitude,@NotNull @ApiParam(value = "Fecha de inicio del rango temporal de las medidas", required = true) @Valid @RequestParam(value = "startDate", required = true) OffsetDateTime startDate,@NotNull @ApiParam(value = "Fecha de fin del rango temporal de las medidas", required = true) @Valid @RequestParam(value = "endDate", required = true) OffsetDateTime endDate) {
        log.info("generate");

        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            Graphic graphic = graphicService.generate(magnitude, startDate, endDate);
            return new ResponseEntity<Graphic>(graphic, HttpStatus.OK);
        }

        return new ResponseEntity<Graphic>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<byte[]> generatePdf(@ApiParam(value = "ID de la gráfica",required=true) @PathVariable("id") Long id) {
        log.info("generatePdf");

	    byte[] bytes = graphicService.generatePdf(id);
		return new ResponseEntity<byte[]>(bytes, HttpStatus.OK);
    }

    public ResponseEntity<byte[]> generatePng(@ApiParam(value = "ID de la gráfica",required=true) @PathVariable("id") Long id) {
        log.info("generatePng");

	    byte[] bytes = graphicService.generatePng(id);
		return new ResponseEntity<byte[]>(bytes, HttpStatus.OK);
    }

    public ResponseEntity<Graphic> getGraphicById(@ApiParam(value = "ID de la gráfica",required=true) @PathVariable("id") Long id) {
        log.info("getGraphicById");

        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            Graphic graphic = graphicService.getById(id);
            return new ResponseEntity<Graphic>(graphic, HttpStatus.OK);
        }

        return new ResponseEntity<Graphic>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Void> sendEmail(@ApiParam(value = "ID de la gráfica",required=true) @PathVariable("id") Long id,@NotNull @ApiParam(value = "Dirección de correo", required = true) @Valid @RequestParam(value = "email", required = true) String email) {
        log.info("sendEmail");

        graphicService.sendEmail(id);
        
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Void> updateGraphic(@ApiParam(value = "Gráfica" ,required=true )  @Valid @RequestBody Graphic body) {
        log.info("updateGraphic");

        graphicService.update(body);

        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

}
