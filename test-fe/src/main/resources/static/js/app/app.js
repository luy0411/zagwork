'use strict'

var zagworkTestApp = angular.module('zagworkTestApp',
							 ['test.controllers', 'test.services' ]);

angular.element(document).ready(function() {
    var userTable = $('#userTable')
    userTable.DataTable({
        "paging":    false,
        "ordering":  false,
        "info":      false,
        "searching": false,
        language : {
            "zeroRecords": " "
        },
    });

});

zagworkTestApp.constant("CONSTANTS", {
	sendAll : "http://localhost:8081/api/main/sendAll"
});