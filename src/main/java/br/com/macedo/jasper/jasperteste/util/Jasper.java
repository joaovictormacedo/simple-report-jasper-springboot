package br.com.macedo.jasper.jasperteste.util;

import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;

import java.io.File;
import java.util.Map;

public class Jasper {


    public static JasperPrint generateReport(File report, Map<String, Object> params) throws JRException {

        return JasperFillManager.fillReport(
                JasperCompileManager.compileReport(report.getAbsolutePath()),
                params,
                new JREmptyDataSource()
        );

    }

    public static byte[] generateReportInPDF(File report, Map<String, Object> params) throws JRException {
        return JasperExportManager.exportReportToPdf(Jasper.generateReport(report, params));
    }

}
