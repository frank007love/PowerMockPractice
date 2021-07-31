package org.tonylin.powermock.fields;

import javax.annotation.Resource;

public class ReportGenerator {

	@Resource
	private ReportTemplateService reportTemplateService;

	public Report generateReport(String reportId) {
		String templateId = reportTemplateService.getTemplateId(reportId);
		/*
		 * Imagine some other code here that generates the report based on the
		 * template id.
		 */
		return new Report("name");
	}
}


