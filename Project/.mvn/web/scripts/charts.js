google.charts.load('current', {'packages':['corechart']});

// Set a callback to run when the Google Visualization API is loaded.
google.charts.setOnLoadCallback(drawChart);

// Callback that creates and populates a data table,
// instantiates the pie chart, passes in the data and
// draws it.
function drawChart() {
// Create the data table.
var data = new google.visualization.DataTable();
data.addColumn('string', 'Topping');
data.addColumn('number', 'Slices');
data.addRows([
  ['Kathmandu', 3],
  ['Taluka', 1],
  ['Khandanpur', 1],
  ['Hetauda', 1],
  ['Bidur', 2]
]);

// Set chart options
var options = {'title':'Affected zones',
			   'width':"70%",
			   'height':"60%"};

// Instantiate and draw our chart, passing in some options.
var chart = new google.visualization.PieChart(document.getElementById('chart_div'));
chart.draw(data, options);
}