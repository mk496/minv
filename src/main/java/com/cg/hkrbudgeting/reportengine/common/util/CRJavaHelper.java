/**
 * This sample code is an example of how to use the Business Objects APIs.
 * Because the sample code is designed for demonstration only, it is
 * unsupported.  You are free to modify and distribute the sample code as needed.
 */
package com.cg.hkrbudgeting.reportengine.common.util;

import com.crystaldecisions.sdk.occa.report.application.DataDefController;
import com.crystaldecisions.sdk.occa.report.application.ReportClientDocument;
import com.crystaldecisions.sdk.occa.report.data.*;
import com.crystaldecisions.sdk.occa.report.document.PaperSize;
import com.crystaldecisions.sdk.occa.report.document.PaperSource;
import com.crystaldecisions.sdk.occa.report.document.PrintReportOptions;
import com.crystaldecisions.sdk.occa.report.document.PrinterDuplex;
import com.crystaldecisions.sdk.occa.report.exportoptions.*;
import com.crystaldecisions.sdk.occa.report.lib.IStrings;
import com.crystaldecisions.sdk.occa.report.lib.PropertyBag;
import com.crystaldecisions.sdk.occa.report.lib.ReportSDKException;
import com.crystaldecisions.sdk.occa.report.lib.ReportSDKPrinterException;

import java.io.InputStream;
import java.util.Collection;
import java.util.Locale;

/**
 * Crystal Reports Java Helper Sample
 *
 * @author Business Objects
 */
public class CRJavaHelper {

    /**
     * Logs on to an existing datasource
     *
     * @param clientDoc The reportClientDocument representing the report being used
     * @param username  The DB logon user name
     * @param password  The DB logon password
     * @throws ReportSDKException
     */
    public static void logonDataSource(ReportClientDocument clientDoc, String username, String password)
            throws ReportSDKException {

        clientDoc.getDatabaseController().logon(username, password);
    }

    /**
     * Changes the DataSource for each Table
     *
     * @param clientDoc     The reportClientDocument representing the report being used
     * @param username      The DB logon user name
     * @param password      The DB logon password
     * @param connectionURL The connection URL
     * @param driverName    The driver Name
     * @param jndiName      The JNDI name
     * @throws ReportSDKException
     */
    public static void changeDataSource(ReportClientDocument clientDoc, String username, String password,
            String connectionURL, String driverName, String jndiName)
            throws ReportSDKException {

        changeDataSource(clientDoc, null, null, username, password, connectionURL, driverName, jndiName);
    }

    /**
     * Changes the DataSource for a specific Table
     *
     * @param clientDoc     The reportClientDocument representing the report being used
     * @param subreportName "" for main report, name of subreport for subreport, null for all reports
     * @param tableName     name of table to change.  null for all tables.
     * @param username      The DB logon user name
     * @param password      The DB logon password
     * @param connectionURL The connection URL
     * @param driverName    The driver Name
     * @param jndiName      The JNDI name
     * @throws ReportSDKException
     */
    public static void changeDataSource(ReportClientDocument clientDoc, String subreportName, String tableName,
            String username, String password, String connectionURL, String driverName,
            String jndiName) throws ReportSDKException {

        PropertyBag propertyBag = null;
        IConnectionInfo connectionInfo = null;
        ITable origTable = null;
        ITable newTable = null;

        // Declare variables to hold ConnectionInfo values.
        // Below is the list of values required to switch to use a JDBC/JNDI
        // connection
        String TRUSTED_CONNECTION = "false";
        String SERVER_TYPE = "JDBC (JNDI)";
        String USE_JDBC = "true";
        String DATABASE_DLL = "crdb_jdbc.dll";
        String JNDI_OPTIONAL_NAME = jndiName;
        String CONNECTION_URL = connectionURL;
        String DATABASE_CLASS_NAME = driverName;

        // The next few parameters are optional parameters which you may want to
        // uncomment
        // You may wish to adjust the arguments of the method to pass these
        // values in if necessary
        // String TABLE_NAME_QUALIFIER = "new_table_name";
        // String SERVER_NAME = "new_server_name";
        // String CONNECTION_STRING = "new_connection_string";
        // String DATABASE_NAME = "new_database_name";
        // String URI = "new_URI";

        // Declare variables to hold database User Name and Password values
        String DB_USER_NAME = username;
        String DB_PASSWORD = password;

        // Obtain collection of tables from this database controller
        if (subreportName == null || subreportName.equals("")) {
            Tables tables = clientDoc.getDatabaseController().getDatabase().getTables();
            for (int i = 0; i < tables.size(); i++) {
                origTable = tables.getTable(i);
                if (tableName == null || origTable.getName().equals(tableName)) {
                    newTable = (ITable) origTable.clone(true);

                    // We set the Fully qualified name to the Table Alias to keep the
                    // method generic
                    // This workflow may not work in all scenarios and should likely be
                    // customized to work
                    // in the developer's specific situation. The end result of this
                    // statement will be to strip
                    // the existing table of it's db specific identifiers. For example
                    // Xtreme.dbo.Customer becomes just Customer
                    newTable.setQualifiedName(origTable.getAlias());

                    // Change properties that are different from the original datasource
                    // For example, if the table name has changed you will be required
                    // to change it during this routine
                    // table.setQualifiedName(TABLE_NAME_QUALIFIER);

                    // Change connection information properties
                    connectionInfo = newTable.getConnectionInfo();

                    // Set new table connection property attributes
                    propertyBag = new PropertyBag();

                    // Overwrite any existing properties with updated values
                    propertyBag.put("Trusted_Connection", TRUSTED_CONNECTION);
                    propertyBag.put("Server Type", SERVER_TYPE);
                    propertyBag.put("Use JDBC", USE_JDBC);
                    propertyBag.put("Database DLL", DATABASE_DLL);
                    propertyBag.put("JNDIOptionalName", JNDI_OPTIONAL_NAME);
                    propertyBag.put("Connection URL", CONNECTION_URL);
                    propertyBag.put("Database Class Name", DATABASE_CLASS_NAME);
                    // propertyBag.put("Server Name", SERVER_NAME); //Optional property
                    // propertyBag.put("Connection String", CONNECTION_STRING); //Optional property
                    // propertyBag.put("Database Name", DATABASE_NAME); //Optional property
                    // propertyBag.put("URI", URI); //Optional property
                    connectionInfo.setAttributes(propertyBag);

                    // Set database username and password
                    // NOTE: Even if the username and password properties do not change
                    // when switching databases, the
                    // database password is *not* saved in the report and must be set at
                    // runtime if the database is secured.
                    connectionInfo.setUserName(DB_USER_NAME);
                    connectionInfo.setPassword(DB_PASSWORD);

                    // Update the table information
                    clientDoc.getDatabaseController().setTableLocation(origTable, newTable);
                }
            }
        }

        // Next loop through all the subreports and pass in the same
        // information. You may consider
        // creating a separate method which accepts
        if (subreportName == null || !(subreportName.equals(""))) {
            IStrings subNames = clientDoc.getSubreportController().getSubreportNames();
            for (int subNum = 0; subNum < subNames.size(); subNum++) {
                Tables tables = clientDoc.getSubreportController().getSubreport(subNames.getString(subNum))
                        .getDatabaseController().getDatabase().getTables();
                for (int i = 0; i < tables.size(); i++) {
                    origTable = tables.getTable(i);
                    if (tableName == null || origTable.getName().equals(tableName)) {
                        newTable = (ITable) origTable.clone(true);

                        // We set the Fully qualified name to the Table Alias to keep
                        // the method generic
                        // This workflow may not work in all scenarios and should likely
                        // be customized to work
                        // in the developer's specific situation. The end result of this
                        // statement will be to strip
                        // the existing table of it's db specific identifiers. For
                        // example Xtreme.dbo.Customer becomes just Customer
                        newTable.setQualifiedName(origTable.getAlias());

                        // Change properties that are different from the original
                        // datasource
                        // table.setQualifiedName(TABLE_NAME_QUALIFIER);

                        // Change connection information properties
                        connectionInfo = newTable.getConnectionInfo();

                        // Set new table connection property attributes
                        propertyBag = new PropertyBag();

                        // Overwrite any existing properties with updated values
                        propertyBag.put("Trusted_Connection", TRUSTED_CONNECTION);
                        propertyBag.put("Server Type", SERVER_TYPE);
                        propertyBag.put("Use JDBC", USE_JDBC);
                        propertyBag.put("Database DLL", DATABASE_DLL);
                        propertyBag.put("JNDIOptionalName", JNDI_OPTIONAL_NAME);
                        propertyBag.put("Connection URL", CONNECTION_URL);
                        propertyBag.put("Database Class Name", DATABASE_CLASS_NAME);
                        // propertyBag.put("Server Name", SERVER_NAME); //Optional property
                        // propertyBag.put("Connection String", CONNECTION_STRING); //Optionalproperty
                        // propertyBag.put("Database Name", DATABASE_NAME); //Optional property
                        // propertyBag.put("URI", URI); //Optional property
                        connectionInfo.setAttributes(propertyBag);

                        // Set database username and password
                        // NOTE: Even if the username and password properties do not
                        // change when switching databases, the
                        // database password is *not* saved in the report and must be
                        // set at runtime if the database is secured.
                        connectionInfo.setUserName(DB_USER_NAME);
                        connectionInfo.setPassword(DB_PASSWORD);

                        // Update the table information
                        clientDoc.getSubreportController().getSubreport(subNames.getString(subNum))
                                .getDatabaseController().setTableLocation(origTable, newTable);
                    }
                }
            }
        }
    }

    /**
     * Passes a populated java.sql.Resultset object to a Table object
     *
     * @param clientDoc     The reportClientDocument representing the report being used
     * @param rs            The java.sql.Resultset used to populate the Table
     * @param tableName     The name of the table
     * @param subreportName The name of the subreport.  If tables in the main report
     *                      is to be used, "" should be passed
     * @throws ReportSDKException
     */
    public static void passResultSet(ReportClientDocument clientDoc, java.sql.ResultSet rs, String tableName,
            String subreportName) throws ReportSDKException {

        if (subreportName.equals("")) {
            clientDoc.getDatabaseController().setDataSource(rs, tableName, tableName + "_ResultSet");
        } else {
            clientDoc.getSubreportController().getSubreport(subreportName).getDatabaseController().setDataSource(
                    rs, tableName, tableName + "_ResultSet");
        }
    }

    /**
     * Passes a populated collection of a Java class to a Table object
     *
     * @param clientDoc     The reportClientDocument representing the report being used
     * @param dataSet       The data used to populate the Table
     * @param c             The fully-qualified class name of the POJO objects being passed
     * @param tableName     The name of the table
     * @param subreportName The name of the subreport.  If tables in the main report
     *                      is to be used, "" should be passed
     * @throws ReportSDKException
     */
    public static void passPOJO(ReportClientDocument clientDoc, Collection<?> dataSet, Class<?> c,
            String tableName, String subreportName) throws ReportSDKException,
            ClassNotFoundException {

        if (subreportName.equals("")) {
            clientDoc.getDatabaseController().setDataSource(dataSet, c, tableName, tableName + "_POJO");
        } else {
            clientDoc.getSubreportController().getSubreport(subreportName).getDatabaseController().setDataSource(
                    dataSet, c, tableName, tableName + "_POJO");
        }
    }

    /**
     * Passes a single discrete parameter value to a report parameter
     *
     * @param clientDoc     The reportClientDocument representing the report being used
     * @param subreportName The name of the subreport.  If tables in the main report
     *                      is to be used, "" should be passed
     * @param parameterName The name of the parameter
     * @param newValue      The new value of the parameter
     * @throws ReportSDKException
     */
    public static void addDiscreteParameterValue(ReportClientDocument clientDoc, String subreportName,
            String parameterName, Object newValue) throws ReportSDKException {

        DataDefController dataDefController = null;
        if (subreportName.equals("")) {
            dataDefController = clientDoc.getDataDefController();
        } else {
            dataDefController = clientDoc.getSubreportController().getSubreport(subreportName)
                    .getDataDefController();
        }

        ParameterFieldDiscreteValue newDiscValue = new ParameterFieldDiscreteValue();
        newDiscValue.setValue(newValue);

        ParameterField paramField = (ParameterField) dataDefController.getDataDefinition().getParameterFields()
                .findField(parameterName, FieldDisplayNameType.fieldName, Locale.getDefault());
        boolean multiValue = paramField.getAllowMultiValue();

        if (multiValue) {
            Values newVals = (Values) paramField.getCurrentValues().clone(true);
            newVals.add(newDiscValue);
            clientDoc.getDataDefController().getParameterFieldController().setCurrentValue(subreportName,
                    parameterName, newVals);
        } else {
            clientDoc.getDataDefController().getParameterFieldController().setCurrentValue(subreportName,
                    parameterName, newValue);
        }
    }

    /**
     * Passes multiple discrete parameter values to a report parameter
     *
     * @param clientDoc     The reportClientDocument representing the report being used
     * @param subreportName The name of the subreport.  If tables in the main report
     *                      is to be used, "" should be passed
     * @param parameterName The name of the parameter
     * @param newValues     An array of new values to get set on the parameter
     * @throws ReportSDKException
     */
    public static void addDiscreteParameterValue(ReportClientDocument clientDoc, String subreportName,
            String parameterName, Object[] newValues) throws ReportSDKException {

        clientDoc.getDataDefController().getParameterFieldController()
                .setCurrentValues(subreportName, parameterName, newValues);
    }

    /**
     * Passes a single range parameter value to a report parameter.  The range is assumed to
     * be inclusive on beginning and end.
     *
     * @param clientDoc     The reportClientDocument representing the report being used
     * @param subreportName The name of the subreport.  If tables in the main report
     *                      is to be used, "" should be passed
     * @param parameterName The name of the parameter
     * @param beginValue    The value of the beginning of the range
     * @param endValue      The value of the end of the range
     * @throws ReportSDKException
     */
    public static void addRangeParameterValue(ReportClientDocument clientDoc, String subreportName,
            String parameterName, Object beginValue, Object endValue)
            throws ReportSDKException {

        addRangeParameterValue(clientDoc, subreportName, parameterName, beginValue, RangeValueBoundType.inclusive,
                endValue, RangeValueBoundType.inclusive);
    }

    /**
     * Passes multiple range parameter values to a report parameter.
     * <p>
     * This overload of the addRangeParameterValue will only work if the
     * parameter is setup to accept multiple values.
     * <p>
     * If the Parameter does not accept multiple values then it is expected that
     * this version of the method will return an error
     *
     * @param clientDoc     The reportClientDocument representing the report being used
     * @param subreportName The name of the subreport.  If tables in the main report
     *                      is to be used, "" should be passed
     * @param parameterName The name of the parameter
     * @param beginValues   Array of beginning values.  Must be same length as endValues.
     * @param endValues     Array of ending values.  Must be same length as beginValues.
     * @throws ReportSDKException
     */
    public static void addRangeParameterValue(ReportClientDocument clientDoc, String subreportName,
            String parameterName, Object[] beginValues, Object[] endValues)
            throws ReportSDKException {

        addRangeParameterValue(clientDoc, subreportName, parameterName, beginValues, RangeValueBoundType.inclusive,
                endValues, RangeValueBoundType.inclusive);
    }

    /**
     * Passes a single range parameter value to a report parameter
     *
     * @param clientDoc      The reportClientDocument representing the report being used
     * @param subreportName  The name of the subreport.  If tables in the main report
     *                       is to be used, "" should be passed
     * @param parameterName  The name of the parameter
     * @param beginValue     The value of the beginning of the range
     * @param lowerBoundType The inclusion/exclusion range of the start of range.
     * @param endValue       The value of the end of the range
     * @param upperBoundType The inclusion/exclusion range of the end of range.
     * @throws ReportSDKException
     */
    public static void addRangeParameterValue(ReportClientDocument clientDoc, String subreportName,
            String parameterName, Object beginValue,
            RangeValueBoundType lowerBoundType, Object endValue,
            RangeValueBoundType upperBoundType) throws ReportSDKException {

        DataDefController dataDefController = null;
        if (subreportName.equals("")) {
            dataDefController = clientDoc.getDataDefController();
        } else {
            dataDefController = clientDoc.getSubreportController().getSubreport(subreportName).getDataDefController();
        }

        ParameterFieldRangeValue newRangeValue = new ParameterFieldRangeValue();
        newRangeValue.setBeginValue(beginValue);
        newRangeValue.setLowerBoundType(lowerBoundType);
        newRangeValue.setEndValue(endValue);
        newRangeValue.setUpperBoundType(upperBoundType);

        ParameterField paramField = (ParameterField) dataDefController.getDataDefinition().getParameterFields()
                .findField(parameterName, FieldDisplayNameType.fieldName, Locale.getDefault());
        boolean multiValue = paramField.getAllowMultiValue();

        if (multiValue) {
            Values newVals = (Values) paramField.getCurrentValues().clone(true);
            newVals.add(newRangeValue);
            clientDoc.getDataDefController().getParameterFieldController()
                    .setCurrentValue(subreportName, parameterName, newVals);
        } else {
            clientDoc.getDataDefController().getParameterFieldController()
                    .setCurrentValue(subreportName, parameterName, newRangeValue);
        }
    }

    /**
     * Passes multiple range parameter values to a report parameter.
     * <p>
     * This overload of the addRangeParameterValue will only work if the
     * parameter is setup to accept multiple values.
     * <p>
     * If the Parameter does not accept multiple values then it is expected that
     * this version of the method will return an error
     *
     * @param clientDoc      The reportClientDocument representing the report being used
     * @param subreportName  The name of the subreport.  If tables in the main report
     *                       is to be used, "" should be passed
     * @param parameterName  The name of the parameter
     * @param beginValues    Array of beginning values.  Must be same length as endValues.
     * @param lowerBoundType The inclusion/exclusion range of the start of range.
     * @param endValues      Array of ending values.  Must be same length as beginValues.
     * @param upperBoundType The inclusion/exclusion range of the end of range.
     * @throws ReportSDKException
     */
    public static void addRangeParameterValue(ReportClientDocument clientDoc, String subreportName,
            String parameterName, Object[] beginValues,
            RangeValueBoundType lowerBoundType, Object[] endValues,
            RangeValueBoundType upperBoundType) throws ReportSDKException {
        // it is expected that the beginValues array is the same size as the endValues array
        ParameterFieldRangeValue[] newRangeValues = new ParameterFieldRangeValue[beginValues.length];
        for (int i = 0; i < beginValues.length; i++) {
            newRangeValues[i] = new ParameterFieldRangeValue();
            newRangeValues[i].setBeginValue(beginValues[i]);
            newRangeValues[i].setLowerBoundType(lowerBoundType);
            newRangeValues[i].setEndValue(endValues[i]);
            newRangeValues[i].setUpperBoundType(upperBoundType);
        }

        clientDoc.getDataDefController().getParameterFieldController()
                .setCurrentValues(subreportName, parameterName, newRangeValues);
    }

    /**
     * Exports a report to PDF
     *
     * @param clientDoc The reportClientDocument representing the report being used
     * @return An <code>InputStream</code> object containing the report document exported to the
     * specified format.
     * @throws ReportSDKException
     */
    public static InputStream exportPDF(ReportClientDocument clientDoc) throws ReportSDKException {
        // PDF export allows page range export. The following routine ensures
        // that the requested page range is valid
        PDFExportFormatOptions pdfOptions = new PDFExportFormatOptions();
        ExportOptions exportOptions = new ExportOptions();
        exportOptions.setExportFormatType(ReportExportFormat.PDF);
        exportOptions.setFormatOptions(pdfOptions);

        // Export the report using the export options.
        return clientDoc.getPrintOutputController().export(exportOptions);
    }

    /**
     * Exports a report to PDF for a range of pages
     *
     * @param clientDoc The reportClientDocument representing the report being used
     * @param startPage Starting page
     * @param endPage   Ending page
     * @return An <code>InputStream</code> object containing the report document exported to the
     * specified format.
     * @throws ReportSDKException
     */
    public static InputStream exportPDF(ReportClientDocument clientDoc, int startPage, int endPage)
            throws ReportSDKException {
        // PDF export allows page range export. The following routine ensures
        // that the requested page range is valid
        PDFExportFormatOptions pdfOptions = new PDFExportFormatOptions();
        pdfOptions.setStartPageNumber(startPage);
        pdfOptions.setEndPageNumber(endPage);
        ExportOptions exportOptions = new ExportOptions();
        exportOptions.setExportFormatType(ReportExportFormat.PDF);
        exportOptions.setFormatOptions(pdfOptions);

        // Export the report using the export options.
        return clientDoc.getPrintOutputController().export(exportOptions);
    }

    /**
     * Exports a report to RTF
     *
     * @param clientDoc The reportClientDocument representing the report being used
     * @return An <code>InputStream</code> object containing the report document exported to the
     * specified format.
     * @throws ReportSDKException
     */
    public static InputStream exportRTF(ReportClientDocument clientDoc) throws ReportSDKException {
        // RTF export allows page range export. The following routine ensures
        // that the requested page range is valid
        RTFWordExportFormatOptions rtfOptions = new RTFWordExportFormatOptions();
        ExportOptions exportOptions = new ExportOptions();
        exportOptions.setExportFormatType(ReportExportFormat.RTF);
        exportOptions.setFormatOptions(rtfOptions);

        // Export the report using the export options.
        return clientDoc.getPrintOutputController().export(exportOptions);
    }

    /**
     * Exports a report to RTF for a range of pages
     *
     * @param clientDoc The reportClientDocument representing the report being used
     * @param startPage Starting page
     * @param endPage   Ending page.
     * @return An <code>InputStream</code> object containing the report document exported to the
     * specified format.
     * @throws ReportSDKException
     */
    public static InputStream exportRTF(ReportClientDocument clientDoc, int startPage, int endPage)
            throws ReportSDKException {
        // RTF export allows page range export. The following routine ensures
        // that the requested page range is valid
        RTFWordExportFormatOptions rtfOptions = new RTFWordExportFormatOptions();
        rtfOptions.setStartPageNumber(startPage);
        rtfOptions.setEndPageNumber(endPage);
        ExportOptions exportOptions = new ExportOptions();
        exportOptions.setExportFormatType(ReportExportFormat.RTF);
        exportOptions.setFormatOptions(rtfOptions);

        // Export the report using the export options.
        return clientDoc.getPrintOutputController().export(exportOptions);
    }

    /**
     * Exports a report to RTF (Editable)
     *
     * @param clientDoc The reportClientDocument representing the report being used
     * @return An <code>InputStream</code> object containing the report document exported to the
     * specified format.
     * @throws ReportSDKException
     */
    public static InputStream exportRTFEditable(ReportClientDocument clientDoc) throws ReportSDKException {
        // RTF export allows page range export. The following routine ensures
        // that the requested page range is valid
        EditableRTFExportFormatOptions rtfOptions = new EditableRTFExportFormatOptions();
        ExportOptions exportOptions = new ExportOptions();
        exportOptions.setExportFormatType(ReportExportFormat.editableRTF);
        exportOptions.setFormatOptions(rtfOptions);

        // Export the report using the export options.
        return clientDoc.getPrintOutputController().export(exportOptions);
    }

    /**
     * Exports a report to RTF (Editable) for a range of pages
     *
     * @param clientDoc The reportClientDocument representing the report being used
     * @param startPage Starting page
     * @param endPage   Ending page.
     * @return An <code>InputStream</code> object containing the report document exported to the
     * specified format.
     * @throws ReportSDKException
     */
    public static InputStream exportRTFEditable(ReportClientDocument clientDoc, int startPage, int endPage)
            throws ReportSDKException {
        // RTF export allows page range export. The following routine ensures
        // that the requested page range is valid
        EditableRTFExportFormatOptions rtfOptions = new EditableRTFExportFormatOptions();
        rtfOptions.setStartPageNumber(startPage);
        rtfOptions.setEndPageNumber(endPage);
        ExportOptions exportOptions = new ExportOptions();
        exportOptions.setExportFormatType(ReportExportFormat.editableRTF);
        exportOptions.setFormatOptions(rtfOptions);

        // Export the report using the export options.
        return clientDoc.getPrintOutputController().export(exportOptions);
    }

    /**
     * Exports a report to CSV
     *
     * @param clientDoc The reportClientDocument representing the report being used
     * @return An <code>InputStream</code> object containing the report document exported to the
     * specified format.
     * @throws ReportSDKException
     */
    public static InputStream exportCSV(ReportClientDocument clientDoc) throws ReportSDKException {

        CharacterSeparatedValuesExportFormatOptions csvOptions = new CharacterSeparatedValuesExportFormatOptions();
        csvOptions.setSeparator(",");
        csvOptions.setDelimiter("\n");

        ExportOptions exportOptions = new ExportOptions();
        exportOptions.setExportFormatType(ReportExportFormat.characterSeparatedValues);
        exportOptions.setFormatOptions(csvOptions);

        // Export the report using the export options.
        return clientDoc.getPrintOutputController().export(exportOptions);
    }

    /**
     * Exports a report to Excel (Data Only)
     *
     * @param clientDoc The reportClientDocument representing the report being used
     * @return An <code>InputStream</code> object containing the report document exported to the
     * specified format.
     * @throws ReportSDKException
     */
    public static InputStream exportExcelDataOnly(ReportClientDocument clientDoc) throws ReportSDKException {

        ExportOptions exportOptions = new ExportOptions();
        exportOptions.setExportFormatType(ReportExportFormat.recordToMSExcel);
        exportOptions.setFormatOptions(new DataOnlyExcelExportFormatOptions());

        // Export the report using the export options.
        return clientDoc.getPrintOutputController().export(exportOptions);
    }

    /**
     * Exports a report to Excel
     *
     * @param clientDoc The reportClientDocument representing the report being used
     * @return An <code>InputStream</code> object containing the report document exported to the
     * specified format.
     * @throws ReportSDKException
     */
    public static InputStream exportExcel(ReportClientDocument clientDoc) throws ReportSDKException {

        ExportOptions exportOptions = new ExportOptions();
        exportOptions.setExportFormatType(ReportExportFormat.MSExcel);
        exportOptions.setFormatOptions(new ExcelExportFormatOptions());

        // Export the report using the export options.
        return clientDoc.getPrintOutputController().export(exportOptions);
    }

    /**
     * Exports a report to XML
     *
     * @param clientDoc The reportClientDocument representing the report being used
     * @return An <code>InputStream</code> object containing the report document exported to the
     * specified format.
     * @throws ReportSDKException
     */
    public static InputStream exportXML(ReportClientDocument clientDoc) throws ReportSDKException {

        ExportOptions exportOptions = new ExportOptions();
        exportOptions.setExportFormatType(ReportExportFormat.XML);
        exportOptions.setFormatOptions(new XMLExportFormatOptions());

        // Export the report using the export options.
        return clientDoc.getPrintOutputController().export(exportOptions);
    }

    /**
     * Exports a report to XML
     *
     * @param clientDoc The reportClientDocument representing the report being used
     * @return An <code>InputStream</code> object containing the report document exported to the
     * specified format.
     * @throws ReportSDKException
     */
    public static InputStream exportXML(ReportClientDocument clientDoc, int indexOfXmlFormats)
            throws ReportSDKException {

        ExportOptions exportOptions = new ExportOptions();
        exportOptions.setExportFormatType(ReportExportFormat.XML);
        exportOptions.setFormatOptions(new XMLExportFormatOptions());
        XMLExportFormatOptions formatOptions = new XMLExportFormatOptions(indexOfXmlFormats);
        exportOptions.setFormatOptions(formatOptions);
        // Export the report using the export options.
        return clientDoc.getPrintOutputController().export(exportOptions);
    }

    /**
     * Prints to the server printer
     *
     * @param clientDoc   The reportClientDocument representing the report being used
     * @param printerName Name of printer used to print the report
     * @throws ReportSDKPrinterException
     */
    public static void printToServer(ReportClientDocument clientDoc, String printerName) throws ReportSDKException {

        PrintReportOptions printOptions = new PrintReportOptions();
        // Note: Printer with the <printer name> below must already be
        // configured.
        printOptions.setPrinterName(printerName);
        printOptions.setJobTitle("Sample Print Job from JRC.");
        printOptions.setPrinterDuplex(PrinterDuplex.useDefault);
        printOptions.setPaperSource(PaperSource.auto);
        printOptions.setPaperSize(PaperSize.paperLetter);
        printOptions.setNumberOfCopies(1);
        printOptions.setCollated(false);

        // Print report
        clientDoc.getPrintOutputController().printReport(printOptions);
    }

    /**
     * Prints a range of pages to the server printer
     *
     * @param clientDoc   The reportClientDocument representing the report being used
     * @param printerName Name of printer used to print the report
     * @param startPage   Starting page
     * @param endPage     Ending page.
     * @throws ReportSDKPrinterException
     */
    public static void printToServer(ReportClientDocument clientDoc, String printerName, int startPage, int endPage)
            throws ReportSDKException {

        PrintReportOptions printOptions = new PrintReportOptions();
        // Note: Printer with the <printer name> below must already be
        // configured.
        printOptions.setPrinterName(printerName);
        printOptions.setJobTitle("Sample Print Job from JRC.");
        printOptions.setPrinterDuplex(PrinterDuplex.useDefault);
        printOptions.setPaperSource(PaperSource.auto);
        printOptions.setPaperSize(PaperSize.paperLetter);
        printOptions.setNumberOfCopies(1);
        printOptions.setCollated(false);
        PrintReportOptions.PageRange printPageRange = new PrintReportOptions.PageRange(startPage, endPage);
        printOptions.addPrinterPageRange(printPageRange);

        // Print report
        clientDoc.getPrintOutputController().printReport(printOptions);
    }
}
