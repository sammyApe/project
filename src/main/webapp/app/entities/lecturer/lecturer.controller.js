(function() {
    'use strict';

    angular
        .module('schedulingProjectApp')
        .controller('LecturerController', LecturerController);

    LecturerController.$inject = ['$scope', '$state', 'Lecturer'];

    function LecturerController ($scope, $state, Lecturer) {
        var vm = this;

        vm.lecturers = [];



        loadAll();

        function loadAll() {
        debugger;
            Lecturer.query(function(result) {
                vm.lecturers = result;
            });
        }
    }
})();
