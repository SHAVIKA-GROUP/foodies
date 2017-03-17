/**
 * @Type : Factory Service
 * @method : OrganizarionService : This will serve the RestFull request for
 *         Organization
 * @Service : get() -> Get Single Organization,
 * @Service : query() -> Get Array List of Organization,
 * @Service : save() -> Insert Single Organization,
 * @Service : delete() -> Delete Single Organization,
 * @Service : update() -> Update Single Organization
 */
indexapp.factory('OrganizationService', [ '$resource', 'API_URL', function($resource, API_URL) {
			
	var organizationURL = API_URL + '/organization/:id';
			console.log("============== service=" + organizationURL);
	
			return $resource(organizationURL, { id : '@id'},// Handy for update & delete. id will be set with id of instance
			{
				update : {
					method : 'PUT' // To send the HTTP Put request when calling this custom update method.
				}

			});
		}]);

/**
 * 
 * @Type : Controller
 * @method : organizationListCtrl : This is controller for Organization List
 *         page...
 * 
 */
indexapp
		.controller(
				'organizationListCtrl',
				[
						'$scope',
						'$location',
						'DTOptionsBuilder',
						'OrganizationService',
						function($scope, $location, DTOptionsBuilder,
								OrganizationService) {

							$scope.navigateOrg = function(organization) {
								var id = (organization != null) ? organization.id
										: '0';
								console
										.log("=================> calling organizationListCtrl /123..."
												+ id);
								$location.url('/organization/' + id);
							}

							loadAllOrganization();
							function loadAllOrganization() {
								$scope.errorsMsg = '';
								// DataTables configurable options
								$scope.dtOptions = DTOptionsBuilder
										.newOptions().withDisplayLength(10)
										.withOption('autoWidth', false)
										.withOption('info', false).withOption(
												'paging', false).withOption(
												'processing', true).withOption(
												'bLengthChange', false);

								$scope.loading = true;
								console
										.log("=================> calling Organization... 1");
								// calling $resource
								var query = OrganizationService.query();
								console
										.log("=================> calling Organization... 2");
								query.$promise
										.then(
												function(data) {
													console
															.log("=================> calling Organization data="
																	+ data.length);
													$scope.loading = false;
													$scope.organizations = (data.length == 0) ? []
															: data;
												},
												function(error) {
													$scope.loading = false;
													$scope.organizations = [];
													$scope.errorsMsg = '  ['
															+ 'Found error to load the data with error '
															+ status + ']';
												});
								console
										.log("=================> calling Organization... 3");
							}// loadAllOrganization end...

						} ]);

/**
 * 
 * @Type : Controller
 * @method : organizationListCtrl : This is controller for Organization List
 *         page...
 * 
 */
indexapp
		.controller(
				'organizationCtrl',
				[
						'$scope',
						'$location',
						'$routeParams',
						'OrganizationService',
						'CommanService',
						function($scope, $location, $routeParams,
								OrganizationService, CommanService) {
							var id = $routeParams.id;
							$scope.organizations = [];
							$scope.organization = new OrganizationService();

							fetchAllOrg = function() {
								self.organizations = OrganizationService
										.query();
							};
							createOrg = function() {
								$scope.organization.$save(function() {
									console.log('User is saved...');
								});
							};
							updateOrg = function() {
								self.organization.$update(function() {
									console.log('User is Updated...');
								});
							};
							deleteOrg = function(identity) {
								var organiz = OrganizationService.get({
									id : identity
								}, function() {
									organiz.$delete(function() {
										console.log('Deleting user with id ',
												identity);
									});
								});
							};

							$scope.reset = function() {
								console.log("=========== inside the reset...");
								// organization = {};
								$scope.orgForm.$setPristine(); // reset Form
							};

							$scope.submit = function() {
								console.log("================Create="
										+ $scope.organization.id);
								if ($scope.organization.id == null) {
									console
											.log("================Before Create.");
									createOrg();
									console
											.log("================After Create.");
								} else {
									console
											.log("================Before Update.");
									updateOrg();
									console
											.log("================After Update.");
								}
							};

							$scope.Countries = [];
							$scope.Currencies = [];
							$scope.TimeZones = [];
							$scope.OrgTypes = [];
							$scope.OrgParents = [ {
								"id" : 1,
								"name" : "KSFC / Head Office"
							}, {
								"id" : 2,
								"name" : "Mandya / Barnch Office"
							}, {
								"id" : 3,
								"name" : "Mysore / Barnch Office"
							} ];

							CommanService.countryList().then(function(data) {
								$scope.Countries = data;
							});

							CommanService.currencyList().then(function(data) {
								$scope.Currencies = data;
							});

							CommanService.organizationTypeList().then(
									function(data) {
										$scope.OrgTypes = data;
									});

							CommanService.timezoneList().then(function(data) {
								$scope.TimeZones = data;
							});

							// var selectedOrgType = {};
							$scope.changedOrgTypeValue = function(item) {
								$scope.organization.organizationType = (item == null) ? {}
										: item;
							}
							$scope.changedOrgValue = function(item) {
								// $scope.organization.organization = (item ==
								// null) ? {} : item;
								// $scope.organization.organization =
								// $scope.organization;
							}
							$scope.changedCountry = function(item) {
								$scope.organization.country = (item == null) ? {}
										: item;
							}
							$scope.changedTimeZone = function(item) {
								$scope.organization.timeZone = (item == null) ? {}
										: item;
							}
							$scope.changedCurrency = function(item) {
								$scope.organization.currency = (item == null) ? {}
										: item;
							}

						} ]);