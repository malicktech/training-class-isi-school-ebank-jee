$(document).ready(function() {

	// Plugin datatable pour afficher les pagination et le tri sur les tableau
	$('#mydatatable').DataTable();

	// par défaut ne pas afficher au chargemetn de la page
	$('#input-group-numCompteDestinataire').hide();

	// Afficher la liste des comptes destinataires si l'option virement est
	// choisie
	$("#typeOperation").change(function() {
		console.log('typeOperation change = ' + $('#typeOperation').val());
		var selected_option = $('#typeOperation').val();
		if (selected_option === 'VIREMENT') {
			console.log('virement selected')
			$('#input-group-numCompteDestinataire').show();
			$('#numCompteDestinaire').prop('required',true);
		}
		if (selected_option != 'VIREMENT') {
			$('#input-group-numCompteDestinataire').hide();
			$('#numCompteDestinaire').prop('required',false);
		}
	})
})
