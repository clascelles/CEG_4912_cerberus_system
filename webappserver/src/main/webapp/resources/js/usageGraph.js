$(document).ready(function(){
	
			
	//chart with points
	if($("#usageGraph").length)
	{

		var plot = $.plot($("#usageGraph"),
			   [ { data: dataValues, label: "Consumption"}], {
				   series: {
					   lines: { show: true  },
					   points: { show: true }
				   },
				   grid: { hoverable: true, clickable: true, backgroundColor: { colors: ["#fff", "#eee"] } },
				   xaxis: {min: minX, max: maxX, tickSize: 1, axisLabel: xLabel,  tickDecimals:0},
				   yaxis: { min: minY, max: maxY, axisLabel: 'Consumption (kW/h)' },
				   colors: ["#539F2E", "#3C67A5"]
				 });

		function showTooltip(x, y, contents) {
			$('<div id="tooltip">' + contents + '</div>').css( {
				position: 'absolute',
				display: 'none',
				top: y + 5,
				left: x + 5,
				border: '1px solid #fdd',
				padding: '2px',
				'background-color': '#dfeffc',
				opacity: 0.80
			}).appendTo("body").fadeIn(200);
		}

		var previousPoint = null;
		$("#usageGraph").bind("plothover", function (event, pos, item) {
			$("#x").text(pos.x.toFixed(2));
			$("#y").text(pos.y.toFixed(2));

				if (item) {
					if (previousPoint != item.dataIndex) {
						previousPoint = item.dataIndex;

						$("#tooltip").remove();
						var x = item.datapoint[0].toFixed(2),
							y = item.datapoint[1].toFixed(2);

						showTooltip(item.pageX, item.pageY,
									y + " kW/h");
					}
				}
				else {
					$("#tooltip").remove();
					previousPoint = null;
				}
		});
		


		$("#usageGraph").bind("plotclick", function (event, pos, item) {
			if (item) {
				$("#clickdata").text(item.series.label + " kW/h");
				plot.highlight(item.series, item.datapoint);
			}
		});
	}
	
	//chart with points
	if($("#usageGraph2").length)
	{

		var plot = $.plot($("#usageGraph2"),
			   [ { data: dataValues2, label: "Consumption"}], {
				   series: {
					   lines: { show: true  },
					   points: { show: true }
				   },
				   grid: { hoverable: true, clickable: true, backgroundColor: { colors: ["#fff", "#eee"] } },
				   xaxis: {min: minX2, max: maxX2, tickSize: 1, axisLabel: xLabel2,  tickDecimals:0},
				   yaxis: { min: minY2, max: maxY2, axisLabel: 'Consumption (kW/h)' },
				   colors: ["#539F2E", "#3C67A5"]
				 });

		function showTooltip(x, y, contents) {
			$('<div id="tooltip">' + contents + '</div>').css( {
				position: 'absolute',
				display: 'none',
				top: y + 5,
				left: x + 5,
				border: '1px solid #fdd',
				padding: '2px',
				'background-color': '#dfeffc',
				opacity: 0.80
			}).appendTo("body").fadeIn(200);
		}

		var previousPoint = null;
		$("#usageGraph2").bind("plothover", function (event, pos, item) {
			$("#x").text(pos.x.toFixed(2));
			$("#y").text(pos.y.toFixed(2));

				if (item) {
					if (previousPoint != item.dataIndex) {
						previousPoint = item.dataIndex;

						$("#tooltip").remove();
						var x = item.datapoint[0].toFixed(2),
							y = item.datapoint[1].toFixed(2);

						showTooltip(item.pageX, item.pageY,
									y + " kW/h");
					}
				}
				else {
					$("#tooltip").remove();
					previousPoint = null;
				}
		});
		


		$("#usageGraph2").bind("plotclick", function (event, pos, item) {
			if (item) {
				$("#clickdata").text(item.series.label + " kW/h");
				plot.highlight(item.series, item.datapoint);
			}
		});
	}
	
});
