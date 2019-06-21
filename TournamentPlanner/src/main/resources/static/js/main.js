$(document).ready( function () {
	
	teamModals();
	
	tournamentModals();
	
	misc();
} );


//MISC
function misc(){      
        
	//DATE PICKER
    $(function () {
        $('#tournamentDatePicker').datetimepicker({
        	format: 'DD.MM.YYYY',
        	locale: 'de',
        	allowInputToggle: true
        	
        });
    });
      
        
};






// TEAM MODALS
function teamModals(){
	
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
    	$('#teamAddEditModal form').attr('action', '/volleymatch/saveTeam');
    	$("#teamAddEditModal .modal-title").html("Team hinzufügen");
    	
    	$('#teamAddEditModal #teamId').val('');
		$('#teamAddEditModal #name').val('');
		$('#teamAddEditModal #memberNames').val('');
    });     
    
    
    //EDIT
    $(".editTeamButton").click( function() {
    	event.preventDefault();
    	$("#teamAddEditModal").modal();
    	$('#teamAddEditModal form').attr('action', '/volleymatch/saveTeam');
    	$("#teamAddEditModal .modal-title").html("Team bearbeiten");    	    	

    	//get Id
    	var teamId = $(this).attr('href');    

    	//set data
    	$('#teamAddEditModal #teamId').val(teamId);
    	$('#teamAddEditModal #teamId').attr('disabled', false);

    	//get object
    	$.get('/volleymatch/team/' + teamId, function(team, status){
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
    	$('#teamDeleteModal form').attr('action', '/volleymatch/deleteTeam/' + teamId);
    });	
	
};




// TOURNAMENT MODALS
function tournamentModals(){
	
    $('#tournamentTable').DataTable({
  	  
    	"columnDefs": [
    		    { "width": "150px", "targets": 0 },
    		    { "orderable": false, "targets": 0 }
    	],
    		  
    	"order": [ 1, 'asc' ]
    } );
    
    
    //ADD
    $("#addTournamentButton").click( function(event) {
    	event.preventDefault();
    	$("#tournamentAddEditModal").modal();
    	$('#tournamentAddEditModal form').attr('action', '/volleymatch/saveTournament');
    	$("#tournamentAddEditModal .modal-title").html("Turnier hinzufügen");
    	
    	$('#tournamentAddEditModal #tournamentId').val('');
		$('#tournamentAddEditModal #name').val('');
		$('#tournamentAddEditModal #location').val('');
		$('#tournamentAddEditModal #tournamentDate').val('');
		$('#tournamentAddEditModal #rounds').val('');
		$('#tournamentAddEditModal #courts').val('');
		$('#tournamentAddEditModal #maxSubsequentRoundsPerTeam').val('');
		$('#tournamentAddEditModal #teamsPerTeam').val('');
		$('#tournamentAddEditModal #playerPerTeam').val('');
				
    });     
    
    
    //EDIT
    $(".editTournamentButton").click( function() {
    	event.preventDefault();
    	$("#tournamentAddEditModal").modal();
    	$('#tournamentAddEditModal form').attr('action', '/volleymatch/saveTournament');
    	$("#tournamentAddEditModal .modal-title").html("Turnier bearbeiten");    	    	

    	//get Id
    	var tournamentId = $(this).attr('href');    

    	//set data
    	$('#tournamentAddEditModal #tournamentId').val(tournamentId);
    	$('#tournamentAddEditModal #tournamentId').attr('disabled', false);

    	//get object
    	$.get('/volleymatch/tournament/' + tournamentId, function(tournament, status){
    		$('#tournamentAddEditModal #name').val(tournament.name);    		
    		$('#tournamentAddEditModal #location').val(tournament.location);
    		$('#tournamentAddEditModal #tournamentDate').val(tournament.tournamentDate);
    		$('#tournamentAddEditModal #rounds').val(tournament.rounds);
    		$('#tournamentAddEditModal #courts').val(tournament.courts);
    		$('#tournamentAddEditModal #maxSubsequentRoundsPerTeam').val(tournament.maxSubsequentRoundsPerTeam);
    		$('#tournamentAddEditModal #teamsPerTeam').val(tournament.teamsPerTeam);
    		$('#tournamentAddEditModal #playerPerTeam').val(tournament.playerPerTeam);    		
    	});
    	    	
    });    
    
    
    //DELETE
    $(".deleteTournamentButton").click( function() {
    	event.preventDefault();
    	$("#tournamentDeleteModal").modal();    	
    	$("#tournamentDeleteModal .modal-title").html("Turnier löschen");    	
    	
    	//get href of current row
    	var tournamentId = $(this).attr('href');
    	
    	//set action
    	$('#tournamentDeleteModal form').attr('action', '/volleymatch/deleteTournament/' + tournamentId);
    });	
         

};


