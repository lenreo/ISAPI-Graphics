package io.swagger.service;

import org.threeten.bp.OffsetDateTime;
import java.util.List;

import io.swagger.model.Graphic;
import io.swagger.model.Magnitude;

public interface GraphicService {

    public boolean check(Graphic graphic);
    public Long add(Graphic graphic);
    public boolean update(Graphic graphic);
    public Graphic getById(Long id);
    public boolean deleteById(Long id);
    public List<Graphic> findByMagnitude(Magnitude magnitude);
    public Graphic generate(Magnitude magnitude, OffsetDateTime startDate, OffsetDateTime endDate);

    public byte[] generatePdf(Long id);
    public byte[] generatePng(Long id);
    public boolean sendEmail(Long id);

}
