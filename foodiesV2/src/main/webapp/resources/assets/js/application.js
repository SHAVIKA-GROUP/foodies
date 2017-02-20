/**
 * 			Document loaded.
 **/
document.addEventListener('DOMContentLoaded',function(){
	$('#login-alert-div').hide();
	$('#reg-alert-div').hide();
	$('#forgot-alert-div').hide();
	$('#spinnerBody').show();
	$('#dataBody').hide();
});

/**
 * 			Document content action.
 **/
$(document).ready(function(){
	
	var jsonData;
	
	/* attach a submit handler to the form */
    $("#login-form").submit(function(event) {
    	/* stop form from submitting normally */
        event.preventDefault();
        /* get some values from elements on the page: */
		var userid = $("#login-userid").val();
		var password = $("#login-password").val();
		if( userid ==='' && password ===''){
			var status_code = 100;
			var status_error = 'Log-In Failed, Try again.';
			loginAlertConfigure(status_code, status_error);
			return;
		}
        /* get some values from elements on the page: */
        var $form = $(this),
        	userid = $form.find('input[name="login-userid"]').val(),
        	password = $form.find('input[name="login-password"]').val(),
        	login_type = $form.find('input[name="login-type"]').val(),
            url = $form.attr('action');
        /* Send the data using post */
        var posting = $.post(url, {
            loginuserid: userid,
            loginpassword: password,
            loginType:login_type
        });
        /* Put the results in a div */
        posting.done(function(data) {
        	var json = jQuery.parseJSON(data);
        	var status_code = json.STATUSCODE;
	        var status_error = json.STATUSERROR;
	        //alert('status_code='+status_code+' / status_error='+status_error);    
	        loginAlertConfigure(status_code, status_error);
	        return;
        });
        /* Put the error in a div */
        posting.fail(function(status, error) {
	        var status_code = 100;
	        var status_error = 'Login failed, Server error. try again!.';
	        //alert('status_code='+status_code+' / status_error='+status_error);    
	        loginAlertConfigure(status_code, status_error);
	        return;
        });
	});

    $("#register-form").submit(function(event) {
    	/* stop form from submitting normally */
        event.preventDefault();
    	if(validateForm($(this))){
            /* get some values from elements on the page: */
            var $form = $(this),
                username = $form.find('input[name="register-username"]').val(),
            	password = $form.find('input[name="register-password"]').val(),
            	cnf_password = $form.find('input[name="register-confirm-pwd"]').val(),
            	email = $form.find('input[name="register-email"]').val(),
            	phone = $form.find('input[name="register-phone"]').val(),
            	login_type = $form.find('input[name="register-type"]').val(),
            	url = $form.attr('action');
            
            if(password !== cnf_password){
            	regAlertConfigure(100, 'Password & confrermation password is not matching... Tyr again.');
            	return false;
            }
            /* Send the data using post */
            var posting = $.post(url, {
                registerUsername : username,
                registerpassword : password,
                registeremail : email,
                registerphone : phone,
                loginType : login_type
            });
            /* Put the results in a div */
            posting.done(function(data) {
            	var json = jQuery.parseJSON(data);
            	var status_code = json.STATUSCODE;
    	        var status_error = json.STATUSERROR;
    	        //alert('status_code='+status_code+' / status_error='+status_error);
    	        regAlertConfigure(status_code, status_error);
    	        return;
            });
            /* Put the error in a div */
            posting.fail(function(status, error) {
    	        var status_code = 100;
    	        var status_error = 'Registeration failed, Server error. try again!.';
    	        //alert('status_code='+status_code+' / status_error='+status_error);    
    	        regAlertConfigure(status_code, status_error);
    	        return;
            });
    	}else{
    		//alert('Not Valid...');
    		return false;
    	}
    });
    
    
	/* attach a submit handler to the form */
    $("#forgot-pwd-form").submit(function(event) {
    	/* stop form from submitting normally */
        event.preventDefault();
        /* get some values from elements on the page: */
		var pwd_email = $("#forgot-pwd-email").val();
		if( pwd_email ===''){
			var status_code = 100;
			var status_error = 'Email should not empty...';
			forgotwdAlertConfigure(status_code, status_error);
			return;
		}
        /* get some values from elements on the page: */
        var $form = $(this),
        	pwdEmail = pwd_email,
        	login_type = $form.find('input[name="forgot-pwd-type"]').val(),
            url = $form.attr('action');
        /* Send the data using post */
        var posting = $.post(url, {
            forgotpwdEmail: pwdEmail,
            loginType:login_type
        });
        /* Put the results in a div */
        posting.done(function(data) {
        	var json = jQuery.parseJSON(data);
	        var status_code = json.STATUSCODE;
	        var status_error = json.STATUSERROR;
	        //alert('status_code='+status_code+' / status_error='+status_error);    
	        forgotwdAlertConfigure(status_code, status_error);
	        return;
        });
        /* Put the error in a div */
        posting.fail(function(status, error) {
	        var status_code = 100;
	        var status_error = 'Mail send failed, Server error. try again!.';
	        //alert('status_code='+status_code+' / status_error='+status_error);    
	        forgotwdAlertConfigure(status_code, status_error);
	        return;
        });
	});

    
	var refreshId = setInterval( function(){
		$('#spinnerBody').show();
		$('#dataBody').hide();
		var getOrders = $.get('/foodiesV2/ordersService');
        getOrders.done(function(data) {
        	jsonData = jQuery.parseJSON(JSON.stringify(data));
            //console.log('data='+jsonData);
            $("#dataBody").empty();
        	var count = 1;
            
            $.each(jsonData, function(i){
            	var orderItemId = jsonData[i]['orders']['order_item_id'];
            	var customerName = jsonData[i]['customer']['first_name']+' '+jsonData[i]['customer']['last_name'];
            	var address = jsonData[i]['customer']['address_1']+', '+jsonData[i]['customer']['address_2']+', '+jsonData[i]['customer']['street']
            	+' '+jsonData[i]['customer']['land_mark']+'. '+jsonData[i]['customer']['city']+'-'+jsonData[i]['customer']['pincode'];
            	var phoneNo = jsonData[i]['customer']['phone'];
            	var price = jsonData[i]['orders']['total_value'];
            	//var status = jsonData[i]['orders']['order_status'];
            	var status = statusValue(jsonData[i]['orders']['order_status']);
            	//console.log('ORDERS==>'+jsonData[i]['orders']['order_item_id']);
            	//console.log('customer==>'+jsonData[i]['customer']['first_name']);
            	var dynTR = "<tr> <td>"+count+"</td> <td>"+orderItemId+"</td> <td>"+customerName+"</td> <td>"+address+"</td> <td>"+phoneNo+"</td> <td> &#8377; "+price+".00</td> "+
        		" <td> <a href='"+orderItemId+"' id='order-item-view' data-toggle='modal' data-target='#modal6' >View Item</a> </td> " +
        		" <td><button id='status' type='button' class='btn btn-default'value='"+orderItemId+"' data-toggle='modal' data-target='#modal7' >"+status+"</button></td> </tr> ";
            	$('#dataBody').append(dynTR);
            	count++;
            });
        	$('#spinnerBody').hide();
        	$('#dataBody').show();
	        return;
        });
        getOrders.fail(function(status, error) {
        	console.log('fail return ....');
    		$('#spinnerBody').show();
    		$('#dataBody').hide();
	        return;
        });
    }, 10000);

	$(document).on('click','#status',function(event){
		event.preventDefault();
		var value = $(this).attr('value');
		$('#order-status-submit').empty();
		$('#order-status-submit-id').val(value).change();
		
        $.each(jsonData, function(i){
        	var orderItemId = jsonData[i]['orders']['order_item_id'];
        	if(value.indexOf(orderItemId) >= 0){
        		var _status = jsonData[i]['orders']['order_status'];
        		_status = (_status === 'PLCD' || _status === 'INIT') ? 'Confirm' : ((_status === 'CNFD') ? 'Deviveried' : ((_status === 'DLRD') ? 'Received' : 'Reject')) ;
        		$('#order-status-submit').text('Click Submit for '+_status+' the Order...');
        	}
        });	
	});

	$(document).on('click','#order-status-submit-btn',function(event){
		event.preventDefault();
		var order_id = $('#order-status-submit-id').val();
		console.log('order_id==>'+order_id);
		$('#spinnerBody').show();
		$('#dataBody').hide();
		var confirm_reqst = $.get('/foodiesV2/ordersConfService', {order_id:order_id});
		confirm_reqst.done(function(data){
			jsonData = jQuery.parseJSON(JSON.stringify(data));
		    //console.log('data='+jsonData);
		    $("#dataBody").empty();
			var count = 1;
		    
		    $.each(jsonData, function(i){
		    	var orderItemId = jsonData[i]['orders']['order_item_id'];
		    	var customerName = jsonData[i]['customer']['first_name']+' '+jsonData[i]['customer']['last_name'];
		    	var address = jsonData[i]['customer']['address_1']+', '+jsonData[i]['customer']['address_2']+', '+jsonData[i]['customer']['street']
		    	+' '+jsonData[i]['customer']['land_mark']+'. '+jsonData[i]['customer']['city']+'-'+jsonData[i]['customer']['pincode'];
		    	var phoneNo = jsonData[i]['customer']['phone'];
		    	var price = jsonData[i]['orders']['total_value'];
		    	var status = statusValue(jsonData[i]['orders']['order_status']);
		    	//console.log('ORDERS==>'+jsonData[i]['orders']['order_item_id']);
		    	//console.log('customer==>'+jsonData[i]['customer']['first_name']);
		    	var dynTR = "<tr> <td>"+count+"</td> <td>"+orderItemId+"</td> <td>"+customerName+"</td> <td>"+address+"</td> <td>"+phoneNo+"</td> <td> &#8377; "+price+".00</td> "+
				" <td> <a href='"+orderItemId+"' id='order-item-view' data-toggle='modal' data-target='#modal6' >View Item</a> </td> " +
				" <td><button id='status' type='button' class='btn btn-default'value='"+orderItemId+"' data-toggle='modal' data-target='#modal7' >"+status+"</button></td> </tr> ";
		    	$('#dataBody').append(dynTR);
		    	count++;
		    });
            $('#modal7').modal('hide');
			$('#spinnerBody').hide();
			$('#dataBody').show();
	        return;
		});
		confirm_reqst.fail(function(status, error){
        	console.log('fail return ....');
    		$('#spinnerBody').show();
    		$('#dataBody').hide();
	        return;
		});
	});
	
	$(document).on('click','#order-item-view',function(event){
		event.preventDefault();
		
		var href = $(this).attr('href');
		//console.log('Called order-item-view...'+href);
		$('#oitemmodal-id').text('Order ID : #'+href);
		$("#OrderItemDataBody").empty();
		$('#OrderItemDataBody').append("<tr> <td colspan='5'> Loanding... </td> </tr>");
		
		
        $.each(jsonData, function(i){
        	var orderItemId = jsonData[i]['orders']['order_item_id'];
        	var totalValue = jsonData[i]['orders']['total_value'];
        	
        	if(href.indexOf(orderItemId) >= 0){
        		console.log(href +'/'+ orderItemId);
        		var orderItems = jsonData[i]['orderitems'];
        		console.log('orderItems.OBJ='+ orderItems);
        		var count = 1;
        		$("#OrderItemDataBody").empty();
        		$.each(jsonData[i]['orderitems'], function(index, _orderItems) {
        			console.log('<index>'+index+' '+_orderItems['food_id']);
        			var foodid = _orderItems['food_id'];
        			var food = '';
        			$.each(jsonData[i]['foods'], function(index, _foods) {
        				console.log('<index/foodid>'+foodid+' '+_foods['id']);
        				if(foodid === _foods['id']){
        					food = _foods['food_name'];
        				}
        			});
        			var quantity = _orderItems['quantity'];
        			var price = _orderItems['price'];
        			var value = _orderItems['value'];
        			var dynTR =  " <tr> <td>"+count+"</td> <td>"+food+"</td> <td>"+quantity+"</td> <td>"+price+"</td> <td>"+value+"</td> </tr>"
        				$('#OrderItemDataBody').append(dynTR);
        			count++;
        		});
        		$('#OrderItemDataBody').append("  <tr> <td colspan='5'> Total : <h3>&#8377; "+totalValue+".00 </h3> </td> </tr>");        		
        	}
        });
		
		
	});
	
//	$('a[data-target="#modal6"]').click(function(){
//		console.log('Called order-item-view...'); 
//	});
	
});

validateForm = function(form){
	var error = false;
	  $.each($('input', form),function(i, field){
		    var fieldId = $(field).attr('id'); 
		    var fieldValue = $(field).val();
		    //alert('fieldId"'+fieldId+'/fieldValue='+fieldValue);
		    if(!$(field).val()){
		    	error = true;
		    	var div = $(field).closest('.form-group');
		    	div.addClass('form-group has-error');
		    	$('.help-block', div).text(fieldId+' can not be empty...');
		    }
	  });
	  return !error;
}
    
function loginAlertConfigure(status_code, status_error){
	$('#login-userid').val('').change();
	$('#login-password').val('').change();
	$('#login-alert-div').show();
	if(status_code === 0)
		$('#login-alert-div').removeClass('alert alert-danger').addClass('alert alert-success');
	else 
		$('#login-alert-div').removeClass('alert alert-success').addClass('alert alert-danger');
	$('#login-alert').text(status_error);
	return;
}

function regAlertConfigure(status_code, status_error){
    $('#register-username').val('').change();
	$('#register-password').val('').change();
	$('#register-confirm-pwd').val('').change();
	$('#register-email').val('').change();
	$('#register-phone').val('').change();
	
	$('#reg-alert-div').show();
	if(status_code === 0)
		$('#reg-alert-div').removeClass('alert alert-danger').addClass('alert alert-success');
	else 
		$('#reg-alert-div').removeClass('alert alert-success').addClass('alert alert-danger');
	$('#reg-alert').text(status_error);
	return;
}

function forgotwdAlertConfigure(status_code, status_error){
	$('#forgot-pwd-email').val('').change();
	$('#forgot-alert-div').show();
	if(status_code === 0)
		$('#forgot-alert-div').removeClass('alert alert-danger').addClass('alert alert-success');
	else 
		$('#forgot-alert-div').removeClass('alert alert-success').addClass('alert alert-danger');
	$('#forgot-alert').text(status_error);
	return;
}

 /*   
$('[id^="login-"]').on('input change',function(){
	$('#login-alert-div').hide();
	$('#login-alert').text('');
});
*/

$('input').on('input change',function(){
	alert("register-");	
	//var div = $(this).closest('.form-group has-error');
	//div.addClass('form-group');
	//$('.help-block', div).text('');
});




function _dataSync(data){
	jsonData = jQuery.parseJSON(JSON.stringify(data));
    //console.log('data='+jsonData);
    $("#dataBody").empty();
	var count = 1;
    
    $.each(jsonData, function(i){
    	var orderItemId = jsonData[i]['orders']['order_item_id'];
    	var customerName = jsonData[i]['customer']['first_name']+' '+jsonData[i]['customer']['last_name'];
    	var address = jsonData[i]['customer']['address_1']+', '+jsonData[i]['customer']['address_2']+', '+jsonData[i]['customer']['street']
    	+' '+jsonData[i]['customer']['land_mark']+'. '+jsonData[i]['customer']['city']+'-'+jsonData[i]['customer']['pincode'];
    	var phoneNo = jsonData[i]['customer']['phone'];
    	var price = jsonData[i]['orders']['total_value'];
    	var status = jsonData[i]['orders']['order_status'];
    	//console.log('ORDERS==>'+jsonData[i]['orders']['order_item_id']);
    	//console.log('customer==>'+jsonData[i]['customer']['first_name']);
    	var dynTR = "<tr> <td>"+count+"</td> <td>"+orderItemId+"</td> <td>"+customerName+"</td> <td>"+address+"</td> <td>"+phoneNo+"</td> <td> &#8377; "+price+".00</td> "+
		" <td> <a href='"+orderItemId+"' id='order-item-view' data-toggle='modal' data-target='#modal6' >View Item</a> </td> " +
		" <td><button id='status' type='button' class='btn btn-default'value='"+orderItemId+"' data-toggle='modal' data-target='#modal7' >"+status+"</button></td> </tr> ";
    	$('#dataBody').append(dynTR);
    	count++;
    });
	$('#spinnerBody').hide();
	$('#dataBody').show();
}


statusValue = function(status){
	var returnstatus = '';
	switch (status) {
	    case 'PLCD':
	    	returnstatus = "Placed";
	        break;
	    case 'INIT':
	    	returnstatus = "Placed";
	        break;
	    case 'CNFD':
	    	returnstatus = "Confirmed";
	        break;
	    case 'DLRD':
	    	returnstatus = "Delivered";
	        break;
	    case 'RCVD':
	    	returnstatus = "received";
	        break;
	    case 'CNLD':
	    	returnstatus = "Canceled";
	        break;
	    case  'RJKD':
	    	returnstatus = "Rejected";
	}
	 return returnstatus;
}







