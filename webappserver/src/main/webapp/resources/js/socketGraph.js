$(document).ready(function(){
	
			
	//chart with points
	if($("#socketA").length)
	{

		var plot1 = $.plot($("#socketA"),
			   [ { data: dataValuesA, label: "Consumption"}], {
				   series: {
					   lines: { show: true  },
					   points: { show: false }
				   },
				   grid: { hoverable: true, clickable: true, backgroundColor: { colors: ["#fff", "#eee"] } },
				   xaxis: {min: minAX, max: maxAX, tickSize: 1,  tickDecimals:0},
				   yaxis: { min: minAY, max: maxAY, axisLabel: 'Consumption (kW/h)' },
				   colors: ["#369bd7", "#3C67A5"]
				 });

		/*function showTooltip(x, y, contents) {
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
		}*/

		/*var previousPoint = null;
		$("#socketA").bind("plothover", function (event, pos, item) {
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
		});*/
		


		/*$("#socketA").bind("plotclick", function (event, pos, item) {
			if (item) {
				$("#clickdata").text(item.series.label + " kW/h");
				plot.highlight(item.series, item.datapoint);
			}
		});*/
	}
	
	if($("#socketB").length)
	{

		var plot2 = $.plot($("#socketB"),
			   [ { data: dataValuesB, label: "Consumption"}], {
				   series: {
					   lines: { show: true  },
					   points: { show: false }
				   },
				   grid: { hoverable: true, clickable: true, backgroundColor: { colors: ["#fff", "#eee"] } },
				   xaxis: {min: minBX, max: maxBX, tickSize: 1,  tickDecimals:0},
				   yaxis: { min: minBY, max: maxBY, axisLabel: 'Consumption (kW/h)' },
				   colors: ["#369bd7", "#3C67A5"]
				 });
		
	}
	
});
