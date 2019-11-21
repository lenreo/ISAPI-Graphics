package io.swagger.service;

import org.threeten.bp.OffsetDateTime;
import java.util.List;

import io.swagger.model.Graphic;

public interface GraphicService {

    public boolean check(Graphic graphic);
    public Long add(Graphic graphic);
    public boolean update(Graphic graphic);
    public Graphic getById(Long id);
    public boolean deleteById(Long id);
    public List<Graphic> findByMagnitude(Long magnitude);
    public Graphic generate(Long magnitude, OffsetDateTime startDate, OffsetDateTime endDate);

    public byte[] generatePdf(Long id);
    public byte[] generatePng(Long id);
    public boolean sendEmail(Long id);

}
