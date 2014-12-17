$(document).ready(function() {
	pageSetUp();
	var pm = new OSystem.Manager.PageManager();
	var contentpath=pm.getContextPath();
	/*
	 * BASIC
	 */
//	$('#dt_basic').dataTable({
//		"sPaginationType" : "bootstrap_full"
//	});
	$('#dt_basic').dataTable( {
		"sDom": "<'dt-top-row'lf>r<'dt-wrapper't><'dt-row dt-bottom-row'<'row'<'col-sm-4'i><'col-sm-4 text-right'p>",
		"bServerSide":true,
		"bProcessing":true,
        "sAjaxSource": contentpath+"/user/queryPageList",
        "fnServerData":function(sSource,aoData,fnCallback){   
            //将客户名称加入参数数组   
//            aoData.push( { "name": "customerName", "value": $("#customerName").val() } );   
        	console.debug(JSON.stringify(aoData));
            $.ajax( {   
                "type": "POST",    
                "contentType": "application/json;charset=UTF-8",   
                "url": sSource,    
                "dataType": "json",   
                "data": JSON.stringify(aoData), //以json格式传递   
                "success": function(res) {
                	console.debug(res.data);
                    fnCallback(res.data);
                }   
            });   
        },
        "aoColumns": [
            { "mDataProp": "userName" },
            { "mDataProp": "status" },
            { "mDataProp": "tel" },
            { "mDataProp": "mail" }
        ]
    });
	/* END BASIC */

	var oTable = $('#datatable_fixed_column')
	.dataTable(
			{
				"sDom" : "<'dt-top-row'><'dt-wrapper't><'dt-row dt-bottom-row'<'row'<'col-sm-6'i><'col-sm-6 text-right'p>>",
				"oLanguage" : {
					"sSearch" : "Search all columns:"
				},
				"bSortCellsTop" : true
			});

	
	/* Add the events etc before DataTables hides a column */
	$("#datatable_fixed_column thead input").keyup(
			function() {
				oTable.fnFilter(this.value, oTable.oApi
						._fnVisibleToColumnIndex(oTable
								.fnSettings(), $("thead input")
								.index(this)));
			});

	$("#datatable_fixed_column thead input").each(function(i) {
		this.initVal = this.value;
	});
	$("#datatable_fixed_column thead input").focus(function() {
		if (this.className == "search_init") {
			this.className = "";
			this.value = "";
		}
	});
	$("#datatable_fixed_column thead input").blur(function(i) {
		if (this.value == "") {
			this.className = "search_init";
			this.value = this.initVal;
		}
	});


	/*
	 * COL ORDER
	 */
	$('#datatable_col_reorder')
			.dataTable(
					{
						"sPaginationType" : "bootstrap",
						"sDom" : "R<'dt-top-row'Clf>r<'dt-wrapper't><'dt-row dt-bottom-row'<'row'<'col-sm-6'i><'col-sm-6 text-right'p>>",
						"fnInitComplete" : function(oSettings,
								json) {
							$('.ColVis_Button')
									.addClass(
											'btn btn-default btn-sm')
									.html(
											'Columns <i class="icon-arrow-down"></i>');
						}
					});

	/* END COL ORDER */

	/* TABLE TOOLS */
	$('#datatable_tabletools')
			.dataTable(
					{
						"sDom" : "<'dt-top-row'Tlf>r<'dt-wrapper't><'dt-row dt-bottom-row'<'row'<'col-sm-6'i><'col-sm-6 text-right'p>>",
						"oTableTools" : {
							"aButtons" : [
									"copy",
									"print",
									{
										"sExtends" : "collection",
										"sButtonText" : 'Save <span class="caret" />',
										"aButtons" : [ "csv",
												"xls", "pdf" ]
									} ],
							"sSwfPath" : "js/plugin/datatables/media/swf/copy_csv_xls_pdf.swf"
						},
						"fnInitComplete" : function(oSettings,
								json) {
							$(this)
									.closest(
											'#dt_table_tools_wrapper')
									.find('.DTTT.btn-group')
									.addClass(
											'table_tools_group')
									.children('a.btn')
									.each(
											function() {
												$(this)
														.addClass(
																'btn-sm btn-default');
											});
						}
					});

	/* END TABLE TOOLS */
})