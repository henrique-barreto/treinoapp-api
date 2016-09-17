$(document).ready(function() {

	$('.tree').treegrid();

	$('.tree').treegrid({
		expanderExpandedClass: 'glyphicon glyphicon-minus',
        expanderCollapsedClass: 'glyphicon glyphicon-plus',
        initialState: 'collapsed'
	});

});