package br.com.macedo.jasper.jasperteste.api;

import br.com.macedo.jasper.jasperteste.component.IbgeComponent;
import br.com.macedo.jasper.jasperteste.util.Jasper;
import lombok.AllArgsConstructor;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/reports")
@AllArgsConstructor
public class ReportController {

    private IbgeComponent ibgeComponent;

    @GetMapping("/brazilian-states")
    public ResponseEntity<byte[]> getReportBrazilianStates() {

        try {

            var reportLocation =ResourceUtils.getFile("classpath:templates/brazilian_states.jrxml");
            var reportExportName = "brazilian_states.pdf";
            var reportContent = ibgeComponent.getIBGEStates();

            Map<String, Object> params = new HashMap<String, Object>();
            params.put("DATA_STATES", new JRBeanCollectionDataSource(reportContent));

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_PDF);
            headers.setContentDispositionFormData("filename", reportExportName);

            return new ResponseEntity<>(Jasper.generateReportInPDF(reportLocation, params), headers, HttpStatus.OK);


        } catch (FileNotFoundException | JRException e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }


    }

}
