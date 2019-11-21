package io.swagger.api;

import java.io.File;
import io.swagger.model.Graphic;
import org.threeten.bp.OffsetDateTime;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.*;
import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;
import java.util.Map;
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2019-11-21T19:15:10.264Z[GMT]")
@Controller
public class GraphicsApiController implements GraphicsApi {

    private static final Logger log = LoggerFactory.getLogger(GraphicsApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public GraphicsApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<Void> addGraphic(@ApiParam(value = "Gráfica" ,required=true )  @Valid @RequestBody Graphic body) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Void> deleteGraphicById(@ApiParam(value = "ID de la gráfica",required=true) @PathVariable("id") Long id) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<List<Graphic>> findGraphicByMagnitude(@NotNull @ApiParam(value = "Magnitud de las medidas", required = true) @Valid @RequestParam(value = "magnitude", required = true) Long magnitude) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<List<Graphic>>(objectMapper.readValue("[ {\n  \"data\" : \"data\",\n  \"magnitude\" : \"{}\",\n  \"id\" : 0,\n  \"start_date\" : \"2000-01-23T04:56:07.000+00:00\"\n}, {\n  \"data\" : \"data\",\n  \"magnitude\" : \"{}\",\n  \"id\" : 0,\n  \"start_date\" : \"2000-01-23T04:56:07.000+00:00\"\n} ]", List.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<List<Graphic>>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<List<Graphic>>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Graphic> generate(@NotNull @ApiParam(value = "Magnitud de las medidas", required = true) @Valid @RequestParam(value = "magnitude", required = true) Long magnitude,@NotNull @ApiParam(value = "Fecha de inicio del rango temporal de las medidas", required = true) @Valid @RequestParam(value = "startDate", required = true) OffsetDateTime startDate,@NotNull @ApiParam(value = "Fecha de fin del rango temporal de las medidas", required = true) @Valid @RequestParam(value = "endDate", required = true) OffsetDateTime endDate) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<Graphic>(objectMapper.readValue("{\n  \"data\" : \"data\",\n  \"magnitude\" : \"{}\",\n  \"id\" : 0,\n  \"start_date\" : \"2000-01-23T04:56:07.000+00:00\"\n}", Graphic.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<Graphic>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<Graphic>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<File> generatePdf(@ApiParam(value = "ID de la gráfica",required=true) @PathVariable("id") Long id) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<File>(objectMapper.readValue("\"\"", File.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<File>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<File>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<File> generatePng(@ApiParam(value = "ID de la gráfica",required=true) @PathVariable("id") Long id) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<File>(objectMapper.readValue("\"\"", File.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<File>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<File>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Graphic> getGraphicById(@ApiParam(value = "ID de la gráfica",required=true) @PathVariable("id") Long id) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<Graphic>(objectMapper.readValue("{\n  \"data\" : \"data\",\n  \"magnitude\" : \"{}\",\n  \"id\" : 0,\n  \"start_date\" : \"2000-01-23T04:56:07.000+00:00\"\n}", Graphic.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<Graphic>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<Graphic>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Void> sendEmail(@ApiParam(value = "ID de la gráfica",required=true) @PathVariable("id") Long id,@NotNull @ApiParam(value = "Dirección de correo", required = true) @Valid @RequestParam(value = "email", required = true) String email) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Void> updateGraphic(@ApiParam(value = "Gráfica" ,required=true )  @Valid @RequestBody Graphic body) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

}
