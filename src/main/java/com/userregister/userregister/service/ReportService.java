package com.userregister.userregister.service;

import com.userregister.userregister.model.Report;
import com.userregister.userregister.repository.ReportRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReportService implements IReportService {
    @Autowired
    public ReportRepository reportRepository;

    @Override
    public void saveReport(Report report) {
        reportRepository.save(report);
    }

    @Override
    public void deleteReport(int id) {
        reportRepository.deleteById(id);
    }

    @Override
    public List<Report> getReports() {
        return reportRepository.findAll();
    }
    
}
