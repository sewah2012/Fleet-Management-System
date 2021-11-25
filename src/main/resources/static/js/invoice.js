$('document').ready(function(){
    $('.editButton').on('click',function(e){
    e.preventDefault();
     let href = $(this).attr('href');

     $.get(href,function(invoice,status){
     $('#editId').val(invoice.id);
     $('#editDate').val(invoice.date);
     $('#editInvoiceStatus').val(invoice.invoicestatusid);
     $('#editClient').val(invoice.clientid);

     $('#editRemarks').val(invoice.remarks);

     })
    $('#editModal').modal();


    })

    $('.deleteButton').on('click', function(e){
        e.preventDefault();

        let href = $(this).attr('href');

        $('#confirmDelete').attr('href', href);
        $('#deleteModal').modal();

    })


})