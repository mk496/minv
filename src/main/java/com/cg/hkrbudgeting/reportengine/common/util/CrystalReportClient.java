package com.cg.hkrbudgeting.reportengine.common.util;

import com.cg.hkrbudgeting.reportengine.common.api.to.MediaResource;
import com.cg.hkrbudgeting.reportengine.common.constant.ConstantReports;
import com.cg.hkrbudgeting.reportengine.common.enums.FileExtension;
import com.crystaldecisions.sdk.occa.report.application.OpenReportOptions;
import com.crystaldecisions.sdk.occa.report.application.ReportClientDocument;
import com.crystaldecisions.sdk.occa.report.lib.ReportSDKException;
import com.google.common.io.ByteStreams;
import com.google.common.io.Resources;
import org.apache.pdfbox.io.MemoryUsageSetting;
import org.apache.pdfbox.multipdf.PDFMergerUtility;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

public class CrystalReportClient {

    private final static Logger logger = LoggerFactory.getLogger(CrystalReportClient.class);

    /**
     * Method to merge all pdf
     *
     * @param pdfs {@link MediaResource} PDFs to merge
     *                      {@link MediaResource} PDFs to merge
     * @return merged PDFs to one {@link MediaResource}
     */
    public static MediaResource mergePDFs(List<MediaResource> pdfs) {

        PDFMergerUtility merger = new PDFMergerUtility();
        ByteArrayOutputStream dest = new ByteArrayOutputStream();
        merger.setDestinationStream(dest);

        for (MediaResource media : pdfs) {
            merger.addSource(new ByteArrayInputStream(media.getData()));
        }

        try {
            merger.mergeDocuments(MemoryUsageSetting.setupMainMemoryOnly());
        } catch (IOException e) {
            logger.error("Error in merging pdfs " + e);
        }

        dest = (ByteArrayOutputStream) merger.getDestinationStream();
        MediaResource result = new MediaResource(FileExtension.PDF.getType(), dest.toByteArray());
        return result;
    }

    /**
     * Method to take number of Pages from pdf MediaResource
     *
     * @param pdf MediaResource
     * @return number of pages
     */
    public static int getTotalPagesOfPDF(MediaResource pdf) {

        PDDocument document = null;
        try {
            document = PDDocument.load(new ByteArrayInputStream(pdf.getData()));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return document.getNumberOfPages();
    }

    /**
     * Method to generate MediaResource with related values from POJO elements
     *
     * @param reportName Name of creating report
     * @param dataset    POJO list which are related to report
     * @param c          type POJO class
     * @param tableAlias Name POJO class
     * @param type       FileExtension extension created report
     * @param parameters Parameters which can't be taken from POJO
     * @return generated MediaResource with value from POJO
     */
    public static MediaResource generateReport(String reportName, @SuppressWarnings("rawtypes") List<?> dataset,
            Class<?> c, String tableAlias, FileExtension type, Map<String, Object> parameters) {

        MediaResource result = null;
        InputStream stream = null;

        switch (type) {
            case PDF:
                stream = CrystalReportClient
                        .exportReportToPDFWithPassPojo(reportName, dataset, c, tableAlias, parameters);
                break;
        }

        try {
            result = new MediaResource(type.getType(), ByteStreams.toByteArray(stream));
        } catch (IOException e) {
            logger.error("Error in creating BudgetPlan report " + e);
        }

        return result;

    }

    private static InputStream exportReportToPDFWithPassPojo(String name, @SuppressWarnings("rawtypes") List dataset,
            Class<?> c, String tableAlias, Map<String, Object> parameters) {

        InputStream result = null;
        String directoryPath = ConstantReports.REPORT_DIRECTORY + "/" + name + ConstantReports.REPORT_EXT;
        ReportClientDocument reportClientDoc = new ReportClientDocument();

        try {

            String path = Resources.getResource(directoryPath).getPath();

            reportClientDoc.open(path, OpenReportOptions._openAsReadOnly);
            CRJavaHelper.passPOJO(reportClientDoc, dataset, c, tableAlias, "");

            if (parameters != null) {
                for (String key : parameters.keySet()) {
                    CRJavaHelper.addDiscreteParameterValue(reportClientDoc, "", key, parameters.get(key));
                }
            }
            result = CRJavaHelper.exportPDF(reportClientDoc);

        } catch (Exception e) {
            logger.error("Error in creating BudgetPlan report " + e);
        } finally {
            try {
                reportClientDoc.close();
            } catch (ReportSDKException e) {
                logger.error("Error in closing report stream" + e);
            }
        }
        return result;
    }
}
