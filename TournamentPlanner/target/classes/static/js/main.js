

$(document).ready( function () {
    $('#teamTable').DataTable({
    	  
    	"columnDefs": [
    		    { "width": "90px", "targets": 0 },
    		    { "orderable": false, "targets": 0 }
    	],
    		  
    	"order": [ 2, 'asc' ]
    } );
    
    
    //ADD
    $("#addTeamButton").click( function(event) {
    	event.preventDefault();
    	$("#teamAddEditModal").modal();
    	$('#teamAddEditModal form').attr('action', '/saveTeam');
    	$("#teamAddEditModal .modal-title").html("Team hinzufügen");
    	
    	$('#teamAddEditModal #teamId').val('');
		$('#teamAddEditModal #name').val('');
		$('#teamAddEditModal #memberNames').val('');
    });     
    
    
    //EDIT
    $(".editTeamButton").click( function() {
    	event.preventDefault();
    	$("#teamAddEditModal").modal();
    	$('#teamAddEditModal form').attr('action', '/saveTeam');
    	$("#teamAddEditModal .modal-title").html("Team bearbeiten");    	    	

    	//get Id
    	var teamId = $(this).attr('href');    

    	//set data
    	$('#teamAddEditModal #teamId').val(teamId);
    	$('#teamAddEditModal #teamId').attr('disabled', false);

    	//get object
    	$.get('/team/' + teamId, function(team, status){
    		$('#teamAddEditModal #name').val(team.name);
    		$('#teamAddEditModal #memberNames').val(team.memberNames);
    	});
    	    	
    });    
    
    
    //DELETE
    $(".deleteTeamButton").click( function() {
    	event.preventDefault();
    	$("#teamDeleteModal").modal();    	
    	$("#teamDeleteModal .modal-title").html("Team löschen");    	
    	
    	//get href of current row
    	var teamId = $(this).attr('href');
    	
    	//set action
    	$('#teamDeleteModal form').attr('action', '/deleteTeam/' + teamId);
    });

    
} );


