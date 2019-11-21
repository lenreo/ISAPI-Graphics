package io.swagger.api;

import java.io.File;
import io.swagger.model.Graphic;
import io.swagger.service.GraphicService;
import io.swagger.model.Magnitude;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.constraints.*;
import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import org.threeten.bp.OffsetDateTime;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2019-11-15T18:00:14.538Z[GMT]")
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

    public ResponseEntity<List<Graphic>> findGraphicByMagnitude(@NotNull @ApiParam(value = "Magnitud de las medidas", required = true) @Valid @RequestParam(value = "magnitude", required = true) Magnitude magnitude) {
        log.info("findGraphicByMagnitude");

        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            List<Graphic> listGraphic = graphicService.findByMagnitude(magnitude);
            return new ResponseEntity<List<Graphic>>(listGraphic, HttpStatus.OK);
        }

        return new ResponseEntity<List<Graphic>>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Graphic> generate(@NotNull @ApiParam(value = "Magnitud de las medidas", required = true) @Valid @RequestParam(value = "magnitude", required = true) Magnitude magnitude,@NotNull @ApiParam(value = "Fecha de inicio del rango temporal de las medidas", required = true) @Valid @RequestParam(value = "startDate", required = true) OffsetDateTime startDate,@NotNull @ApiParam(value = "Fecha de fin del rango temporal de las medidas", required = true) @Valid @RequestParam(value = "endDate", required = true) OffsetDateTime endDate) {
        log.info("generate");

        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            Graphic graphic = graphicService.generate(magnitude, startDate, endDate);
            return new ResponseEntity<Graphic>(graphic, HttpStatus.OK);
        }

        return new ResponseEntity<Graphic>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<File> generatePdf(@ApiParam(value = "ID de la gráfica",required=true) @PathVariable("id") Long id) {
        log.info("generatePdf");

        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            byte[] bytes = graphicService.generatePdf(id);
            return new ResponseEntity<File>(HttpStatus.OK);
        }

        return new ResponseEntity<File>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<File> generatePng(@ApiParam(value = "ID de la gráfica",required=true) @PathVariable("id") Long id) {
        log.info("generatePng");

        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("image/png")) {
            byte[] bytes = graphicService.generatePng(id);
            return new ResponseEntity<File>(HttpStatus.OK);
        }

        return new ResponseEntity<File>(HttpStatus.NOT_IMPLEMENTED);
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