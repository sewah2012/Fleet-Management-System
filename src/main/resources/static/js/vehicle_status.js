$('document').ready(function(){
    $('.editButton').on('click',function(e){
    e.preventDefault();
     let href = $(this).attr('href');

     $.get(href,function(vehicle_status,status){
     $('#editId').val(vehicle_status.id);
     $('#editDescription').val(vehicle_status.description);
     $('#editDetails').val(vehicle_status.details);


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