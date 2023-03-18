package com.userregister.userregister.service;

import com.userregister.userregister.model.Report;
import java.util.List;

public interface IReportService {
    public void saveReport(Report report);
    public void deleteReport(int id);
    public List<Report> getReports();
}
