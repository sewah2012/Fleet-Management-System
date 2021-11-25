$('document').ready(function(){
    $('.editButton').on('click',function(e){
    e.preventDefault();
     let href = $(this).attr('href');

     $.get(href,function(state,status){
     $('#editId').val(state.id);
     $('#editDetails').val(state.details);
     $('#editCountry').val(state.countryid);
     $('#editCode').val(state.code);
     $('#editCapital').val(state.capital);
     $('#editName').val(state.name);

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