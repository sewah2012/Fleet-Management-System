$('document').ready(function(){
    $('.editButton').on('click',function(e){
    e.preventDefault();
     let href = $(this).attr('href');

     $.get(href,function(country,status){
     $('#editId').val(country.id);
     $('#editDescription').val(country.description);
     $('#editCountry').val(country.country);
     $('#editCode').val(country.code);
     $('#editCapital').val(country.capital);
     $('#editContinent').val(country.continent);
     $('#editNationality').val(country.nationality);

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