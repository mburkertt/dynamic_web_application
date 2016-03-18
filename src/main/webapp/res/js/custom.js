$(function(){
	"use strict";	
	
	function appendSpringBatchJobValues(){
    	  $.ajax({
    		  url: "batchData.json",			  
    		  dataType: "json",
    		  type: "GET",
			  isLocal:true,
    	  
              success  : function(oData) {
				  var tableIDArray = $(".dataTable").map(function() { 
					   return this.id;
				   }).get();
				  $.each(tableIDArray,function(i,l){
					  var tableID = l 
					 
					  var batchDataJson = 'batchData.json'
					  var jsonList = oData[tableID];
						  var jsonListLength = jsonList.length; 
						  
					  for (var i = 0; i < jsonListLength; i++){
							var jsonObj = jsonList[i];
												  
						if (jsonObj != null && jsonObj != undefined)  {
								
							
							if(jsonObj.projectStatus == true) {
								$("#projectStatus_"+jsonObj.object_Id).addClass('btn-success');
							}
							else{
								$("#projectStatus_"+jsonObj.object_Id).addClass('btn-danger');
							}
							
							$("#springBatchUrl_"+jsonObj.object_Id).attr("data-link" , batchDataJson);
															
							if(jsonObj.springBatchValue == 'COMPLETED') {
								$("#springBatchValue_"+jsonObj.object_Id).find('a').addClass('btn btn-success');
							} else if (jsonObj.springBatchValue == 'STARTED'){
								$("#springBatchValue_"+jsonObj.object_Id).find('a').addClass('btn btn-primary');
							}
							else {
								if (jsonObj.springBatchValue == 'NOT_AVAILABLE') {
									$("#springBatchValue_"+jsonObj.object_Id).find('a').addClass('btn btn-warning');
								} else {									
								$("#springBatchValue_"+jsonObj.object_Id).find('a').addClass('btn btn-danger');
								}
							}
								
							$('#springBatchFailureUrl_'+jsonObj.object_Id).attr("data-link" , batchDataJson);
							if(jsonObj.springBatchFailureTime != null){									
								$('#springBatchValue_'+jsonObj.object_Id).append('<p>' + jsonObj.springBatchFailureTime + '</p>');
							}
							} else {
								$("#springBatchValue_"+jsonObj.object_Id).append('<p>Fehler keine Werte</p>');
								$('#springBatchFailureUrl_'+jsonObj.object_Id).append('<p>Fehler keine Werte</p>');
							}
							 
						  
						  if (jsonObj.springBatchValueAcc != null && jsonObj.springBatchValueAcc != undefined) {
							  
							$("#springBatchUrlAcc_"+jsonObj.object_Id).attr("data-link" , batchDataJson);
							
							if(jsonObj.springBatchValueAcc == 'COMPLETED'){
							  $("#springBatchValueAcc_"+jsonObj.object_Id).find('a').addClass('btn btn-success');
							}
							 else if (jsonObj.springBatchValue == 'STARTED'){
									$("#springBatchValue_"+jsonObj.object_Id).find('a').addClass('btn btn-primary');
								}
							else {
								if (jsonObj.springBatchValueAcc == 'NOT_AVAILABLE') {														
									$("#springBatchValueAcc_"+jsonObj.object_Id).find('a').addClass('btn btn-warning');
									}
								
								else {
								 $("#springBatchValueAcc_"+jsonObj.object_Id).find('a').addClass('btn btn-danger');
								}
							}
//							 $('#springBatchFailureUrlAcc_'+jsonObj.object_Id).attr("data-link" , batchDataJson);
							 if(jsonObj.springBatchFailureTimeAcc != null) {
							 	$('#springBatchValueAcc_'+jsonObj.object_Id).append('<p>' + jsonObj.springBatchFailureTimeAcc + '</p>');
							 }
						  }
						else
						  {
						  $("#springBatchValueAcc_"+jsonObj.object_Id).find('a').addClass('btn btn-warning').append('<span> nicht Vorhanden </span>');
						  $('#springBatchFailureUrlAcc_'+jsonObj.object_Id).find('a').addClass('btn btn-warning').append('<span> nicht Vorhanden </span>');
						  }
						  
						  
						  
					  }
				  });
                },
                error  : function(jqXHR, textStatus, errorThrown) {
                  console.error(errorThrown);
                }
              });
            }
     appendSpringBatchJobValues();	 	
	
	
	$('.refresh').click(function() { 
		var tableID = $(this).parents('.dataTable').attr('id');
		var tableCountry = 	$(this).parents('tr').find('td:nth-child(3) a').attr('data-country');
		var refreshLink = 'refresh.json';
		
		 $.ajax({
			url:refreshLink,
			dataType: 'json',
			type: "GET",
			success  : function(data) {
            	  var jsonList = data[tableID];				  
            	  var jsonListLength = jsonList.length;
				
                  for (var i = 0; i < jsonListLength; i++){
                	  var jsonObj = jsonList[i];                	 
					  var countryID = jsonObj.timestampInformationObject.countryId;	
					  					 				  
					  if(countryID == tableCountry){						 
                		if (jsonObj != null && jsonObj != undefined)  {															
                	 		$("#springBatchUrl_"+jsonObj.batchInformationObject.object_Id).attr("data-link" , refreshLink);                	  	
							if(jsonObj.batchInformationObject.springBatchValue == 'COMPLETED') {
								$("#springBatchValue_"+jsonObj.batchInformationObject.object_Id).find('a').addClass('btn btn-success');
							} else if (jsonObj.batchInformationObject.springBatchValue == 'STARTED'){
								$("#springBatchValue_"+jsonObj.batchInformationObject.object_Id).find('a').addClass('btn btn-primary');
							}
							else {
								if (jsonObj.batchInformationObject.springBatchValue == 'NOT_AVAILABLE') {
									$("#springBatchValue_"+jsonObj.batchInformationObject.object_Id).find('a').addClass('btn btn-warning');
								} else {
								$("#springBatchValue_"+jsonObj.batchInformationObject.object_Id).find('a').addClass('btn btn-danger');
								}
							}
							
                	  		$('#springBatchFailureUrl_'+jsonObj.batchInformationObject.object_Id).attr("data-link" , refreshLink);
                	  		$('#springBatchValue_'+jsonObj.batchInformationObject.object_Id).find('p').text(jsonObj.batchInformationObject.springBatchFailureTime);	
																
						} else {
							$("#springBatchValue_"+jsonObj.batchInformationObject.object_Id).find('p').text("Fehler keine Werte");
							$('#springBatchFailureUrl_'+jsonObj.batchInformationObject.object_Id).find('p').text("Fehler keine Werte");
						}            		 
                	  
						if (jsonObj.batchInformationObject.springBatchValueAcc != null && jsonObj.batchInformationObject.springBatchValueAcc != undefined) {
							$("#springBatchUrlAcc_"+jsonObj.batchInformationObject.object_Id).attr("data-link" , refreshLink);
							
							if(jsonObj.batchInformationObject.springBatchValueAcc == 'COMPLETED'){
							  $("#springBatchValueAcc_"+jsonObj.batchInformationObject.object_Id).find('a').addClass('btn btn-success');
							} else {
								if (jsonObj.batchInformationObject.springBatchValueAcc == 'NOT_AVAILABLE') {								
									$("#springBatchValueAcc_"+jsonObj.batchInformationObject.object_Id).find('a').addClass('btn btn-warning');
									}
								 else if (jsonObj.batchInformationObject.springBatchValue == 'STARTED'){
										$("#springBatchValue_"+jsonObj.batchInformationObject.object_Id).find('a').addClass('btn btn-primary');
									}
								else {
								 $("#springBatchValueAcc_"+jsonObj.batchInformationObject.object_Id).find('a').addClass('btn btn-danger');
								}
							}
							 $('#springBatchFailureUrlAcc_'+jsonObj.timestampInformationObject.object_Id).attr("data-link" , refreshLink);
							 $('#springBatchValueAcc_'+jsonObj.timestampInformationObject.object_Id).find('p').text(jsonObj.batchInformationObject.springBatchFailureTimeAcc);
						  }
					  }
                	  
				  }
				
                },
                error  : function(jqXHR, textStatus, errorThrown) {
                  console.error(errorThrown);
                }
			});
		
	});
	
	 $('td[data-modal="true"]').click(function(){
		var batchLink = $(this).find('a').attr('data-link');		
		var batchTitle = $(this).attr('data-label');
		var firstWordBatchTitle = batchTitle.slice(0,batchTitle.indexOf(" "));
		var tableID = $(this).parents('.dataTable').attr('id');		
		var tableCountry = 	$(this).parents('tr').find('td:nth-child(3) a').attr('data-country');
		var tableDevice = $(this).parents('tr').find('td:nth-child(2) i').attr('data-device');
		
		 if(batchLink != undefined && firstWordBatchTitle == 'Spring'){			 			 
			 $.ajax({ 
			  type: "GET", 
			  url: batchLink,
			  dataType: 'json',
			  success: function(data){ 			
				  var jsonList = data[tableID]; 
				  var jsonListLength = jsonList.length;	
				  for (var i = 0; i < jsonListLength; i++){	
				  	var jsonObj = jsonList[i];
						 
					if (batchLink == 'batchData.json'){
						var countryID = jsonObj.countryId;
						var deviceID = jsonObj.deviceId;
													
						if(batchTitle == 'Spring Batch Status' && countryID == tableCountry && deviceID == tableDevice || batchTitle == 'Spring Batch Fehler' && countryID == tableCountry && deviceID == tableDevice) {
																				
							var plain = JSON.stringify(jsonObj.jobParameters);				 		  
							var parameters = plain.split(',');
							var input = "";							
							for (var i = 0; i < parameters.length; i++){	
								  input += parameters[i] +'<br>';
								  }
							
							if(jsonObj.springBatchValue == 'NOT_AVAILABLE'){																					
								BootstrapDialog.show({
									  title:batchTitle,
									  message: $('<div> BatchJobsUrl'+jsonObj.object_Id+ ': <a href="'+jsonObj.springBatchUrl+'"target="_blank">BatchAdmin</a><br><br>There was no connection to the specified Batchjob Available while Crawling. 503</div>').load('Nicht verfügbar')				
								  });
								  return false;  
								} else {															 
								BootstrapDialog.show({
										size: 'size-wide',
										title:batchTitle,
										message: 'BatchJobsUrl'+jsonObj.object_Id+ ': <a href="'+jsonObj.springBatchUrl+'"target="_blank">BatchAdmin</a><br><br>'+input						
								});
								return false;
							}
						 } else if(batchTitle == 'Spring Batch Acc' && countryID == tableCountry && deviceID == tableDevice) {						 							
						 	
							var plain = JSON.stringify(jsonObj.jobParametersAcc);							
							var parameters = plain.split(',');
							var input = "";														
							for (var i = 0; i < parameters.length; i++){	
										  input += parameters[i] +'<br>';
									  }																				
								if(jsonObj.springBatchValueAcc == 'NOT_AVAILABLE'){								 
								  BootstrapDialog.show({
										  title:batchTitle,
										  message: $('<div> BatchJobsUrl'+jsonObj.object_Id+ ': <a href="'+jsonObj.springBatchUrl+'"target="_blank">BatchAdmin</a><br><br>There was no connection to the specified Batchjob Available while Crawling. 503</div>').load('Nicht verfügbar')				
									  });
									  return false;  
								  }	else {		 
								  BootstrapDialog.show({
									  size: 'size-wide',
									  title:batchTitle,
									  message: 'BatchJobsUrl'+jsonObj.object_Id+ ': <a href="'+jsonObj.springBatchUrlAcc+'"target="_blank">BatchAdmin</a><br><br>'+input						
								  });
								  return false;
								}
							}
							 
						 } 					  
					  else if(batchLink == 'refresh.json'){
						 var countryID = jsonObj.timestampInformationObject.countryId;						 
						 var deviceID = jsonObj.timestampInformationObject.deviceId;
						 
						 if(batchTitle == 'Spring Batch Status' && countryID == tableCountry && deviceID == tableDevice || batchTitle == 'Spring Batch Fehler' && countryID == tableCountry && deviceID == tableDevice) {
							var plain = JSON.stringify(jsonObj.batchInformationObject.jobParameters);				 		  
							var parameters = plain.split(',');
							var input = "";
							for (var i = 0; i < parameters.length; i++){	
								  input += parameters[i] +'<br>';
								  }		
								 	 
								  if(jsonObj.batchInformationObject.springBatchValue == 'NOT_AVAILABLE'){
									BootstrapDialog.show({
										  title:batchTitle,
										  message: $('<div> BatchJobsUrl'+jsonObj.object_Id+ ': <a href="'+jsonObj.springBatchUrl+'"target="_blank">BatchAdmin</a><br><br>There was no connection to the specified Batchjob Available while Crawling. 503</div>').load('Nicht verfügbar')				
									  });  
									  return false;
								  }	else {	 
								  BootstrapDialog.show({
										  size: 'size-wide',
										  title:batchTitle,
										  message: 'BatchJobsUrl'+jsonObj.object_Id+ ': <a href="'+jsonObj.springBatchUrl+'"target="_blank">BatchAdmin</a><br><br>'+input					
								  });
								  return false;
							  }
						  }else if(batchTitle == 'Spring Batch Acc' && countryID == tableCountry && deviceID == tableDevice) {							
							var plain = JSON.stringify(jsonObj.batchInformationObject.jobParametersAcc);
							var parameters = plain.split(',');
							var input = "";
							for (var i = 0; i < parameters.length; i++){	
										  input += parameters[i] +'<br>';
									  }										  
								  	 
							if(jsonObj.batchInformationObject.springBatchValueAcc == 'NOT_AVAILABLE'){
								  BootstrapDialog.show({
										title:batchTitle,
										message: $('<div> BatchJobsUrl'+jsonObj.object_Id+ ': <a href="'+jsonObj.springBatchUrl+'"target="_blank">BatchAdmin</a><br><br>There was no connection to the specified Batchjob Available while Crawling. 503</div>').load('Nicht verfügbar')				
									});  
									return false;
								} else {		 
								BootstrapDialog.show({
									size: 'size-wide',
									title:batchTitle,
									message: 'BatchJobsUrl'+jsonObj.object_Id+ ': <a href="'+jsonObj.springBatchUrlAcc+'"target="_blank">BatchAdmin</a><br><br>'+input					
								});
								return false;
							  }
						  	}							
						 } 
					  }
					}
				});
			
			return false;	
		 
		 } else if (batchLink == undefined) {
			BootstrapDialog.show({
				  title:batchTitle,
				  message: $('<div>There is no connection to the specified Batchjob Available. 503</div>').load('Nicht verfügbar')				
			  });
			  return false;
		} else {
			var stager = $(this).attr('data-label');
			var tableDevice = $(this).parents('tr').find('td:nth-child(2) i').attr('data-device');	
					 			
			$.ajax({ 
			  type: "GET", 
			  url: 'ts.json',
			  dataType: 'json',
			  success: function(data){ 			
				  var jsonList = data[tableID]; 
				  var jsonListLength = jsonList.length;	
				  for (var i = 0; i < jsonListLength; i++){				  	
					var jsonObj = jsonList[i];    
					var countryID = jsonObj.countryId; 
					var deviceID = jsonObj.deviceId;
										
					if(countryID == tableCountry  && deviceID == tableDevice){
						if(stager == 'Lokal'){											  					             	 
						var timeStamp = jsonObj.dateLocal;	
						var jsDate = new Date(timeStamp);													
						BootstrapDialog.show({				
							  title:batchTitle,
							  message: jsDate			
						  });
						  return false;
						}else if(stager == 'Remote'){
							var timeStamp = jsonObj.dateRemote;	
							var jsDate = new Date(timeStamp);													
							BootstrapDialog.show({				
							  title:batchTitle,
							  message: jsDate			
						  });
						  return false;
						}
					}
					
				  }
			  }
			});	 
		}
	 });
		
	
	$('#BLUE_RMI').DataTable({
		paging:   false,
        info:     false,
		responsive: true,
		order: [[ 1, "asc" ]]
	});
	
	$('#BLUE_RAF').DataTable({
		paging:   false,
        info:     false,
		responsive: true,
		order: [[ 1, "asc" ]]
	});
	
	$('#BLUE_RAP').DataTable({
		paging:   false,
        info:     false,
		responsive: true,
		order: [[ 1, "asc" ]]
	});
	
	$('#BLUE_RLA').DataTable({
		paging:   false,
        info:     false,
		responsive: true,
		order: [[ 1, "asc" ]]
	});
	
	$('#SKIL_RLA').DataTable({
		paging:   false,
        info:     false,
		responsive: true,
		order: [[ 1, "asc" ]]
	});
	
	$('#DIY').DataTable({
		paging:   false,
        info:     false,
		responsive: true,
		order: [[ 1, "asc" ]]
	});
	
	$('#DREMEL').DataTable({
		paging:   false,
        info:     false,
		responsive: true,
		order: [[ 1, "asc" ]]
	});
	
	$('thead tr th:nth-child(2)').append('<i class="glyphicon glyphicon-sort"></i>');
	
	$('.nav-stacked').find('li:first').addClass('active');
	$('.tab-content').find('.tab-pane:first').addClass('active')
})