// validation input
var numChk = new RegExp('^[0-9]*$');

// Handle edit quanty cart
$('.btn-edit-cart').on('click', function() {
	
	var id = $(this).data('id');
	var quanty = $('#quanty-cart-' + id).val();
	
	if(quanty <= 0) {
		alert('Số lượng phải lớn hơn 0!');
		return;
	}
	if(!numChk.test(quanty)) {
		alert('Bạn phải nhập số!');
		return;
	}
	
	window.location = 'edit-cart-pay/' + id + '/' + quanty;
});
