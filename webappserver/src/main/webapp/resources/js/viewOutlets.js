$(document).ready(function(){
	
	var second = 1000;
	var minute = 60*second;
	
	var refreshRate = 30*second;	
	var timeRange = 11*minute; //11 mins
	var totalPoints = (timeRange / refreshRate) + 2;
	
	var dataMax = 6;
	var dataMin = 0;
	
	//time connected variables
	var socketAHasConnection = false;
	var socketBHasConnection = false;
	
	var s1 = 0;
	var m1 = 0;
	var h1 = 0;
	
	var s2 = 0;
	var m2 = 0;
	var h2 = 0;
	
	function getTime() {
		var timezoneOffset = new Date().getTimezoneOffset() * (10*minute);
		var currentTime = new Date().getTime();
		return currentTime - timezoneOffset;
	}
	
	function pad(number) {
		if(number < 10) {
			return "0" + number;
		}
		return number;
	}
	
	
	function getUtility(consumption) {
		if(consumption == 0) {
			return "None";
		}
		if(consumption == 1) {
			return "Phone charger";
		}
		if(consumption == 2) {
			return "Clock Radio";
		}
		if(consumption == 3) {
			return "Computer";
		}
		if(consumption == 4) {
			return "Toaster";
		}
		if(consumption == 5) {
			return "Hair dryer";
		}

		return "Television";
	}
	
	
	// we use an inline data source in the example, usually data would
	// be fetched from a server
	var data1 = [];
	function getRandomData1() {		
		if (data1.length > 0)
			data1 = data1.slice(1);

		// do a random walk
		while (data1.length < totalPoints) {
			var prev = data1.length > 0 ? data1[data1.length - 1] : dataMin;
			var hasChanged = (Math.random() > 0.6);
			var plusMinus = Math.random();
			var offset = (hasChanged) ? Math.random() * dataMax : 0;
			var y = (plusMinus > 0.5 && prev < dataMax/2) ? prev + offset : prev - offset;
			if (y < dataMin)
				y = dataMin;
			if (y > dataMax)
				y = dataMax;
			data1.push(Math.round(y));
		}
		
		// zip the generated y values with the x values
		var res = [];
		
		var starttime = getTime() - timeRange -(2*refreshRate);
		starttime += (starttime % refreshRate);
		
		for (var i = 0; i < totalPoints; ++i) {
			starttime += refreshRate;
			res.push([starttime, data1[i]]);
			if(i == totalPoints - 1) {
				$("#utilityA").text(getUtility(data1[i]));				
		        $("#usageA").text(data1[i] + " amps");
	        	socketAHasConnection = (data1[i] != 0);
			}			
		}
		
		return res;
	}

	var data2 = [];
	function getRandomData2() {		
		if (data2.length > 0)
			data2 = data2.slice(1);

		// do a random walk
		while (data2.length < totalPoints) {
			var prev = data2.length > 0 ? data2[data2.length - 1] : dataMin;
			var hasChanged = (Math.random() > 0.6);
			var plusMinus = Math.random();
			var offset = (hasChanged) ? Math.random() * dataMax : 0;
			var y = (plusMinus > 0.5 && prev < dataMax/2) ? prev + offset : prev - offset;
			if (y < dataMin)
				y = dataMin;
			if (y > dataMax)
				y = dataMax;
			data2.push(Math.round(y));
		}
		
		// zip the generated y values with the x values
		var res = [];
		
		var starttime = getTime() - timeRange -(2*refreshRate);
		starttime += (starttime % refreshRate);
		
		for (var i = 0; i < totalPoints; ++i) {
			starttime += refreshRate;
			res.push([starttime, data2[i]]);
			if(i == totalPoints - 1) {
				$("#utilityB").text(getUtility(data2[i]));	
		        $("#usageB").text(data2[i] + " amps");
	        	socketBHasConnection = (data2[i] != 0);
			}			
		}
		
		return res;
	}
		
	//realtime chart
	if(($("#socketA").length) || ($("#socketB").length))
	{
		var currentTime = getTime();
		
		var options = {
			series: { 	shadowSize: 1,
						lines: { show: true, fill: true, fillColor: "rgba(68, 160, 215, 0.3)" }
					},
			grid: { hoverable: true },
			yaxis: { label: "Current (amps)", min: dataMin, max: dataMax },
			xaxis: { mode: "time", min: currentTime - timeRange, max: currentTime, ticks: 10 },
			colors: [ "rgba(68, 160, 215, 0.3)", "rgba(68, 160, 215, 0.3)" ]
		};
		
		var plot1 = $.plot($("#socketA"), [ getRandomData1() ], options);
		var plot2 = $.plot($("#socketB"), [ getRandomData2() ], options);
		function update() {

			var currentTime = getTime();
			
			options.xaxis.min = currentTime - timeRange;
			options.xaxis.max = currentTime;
			
			plot1 = $.plot($("#socketA"), [ getRandomData1() ], options);
			plot2 = $.plot($("#socketB"), [ getRandomData2() ], options);
			
			plot1.draw();
			plot2.draw();
			
			var updateIn = refreshRate - (currentTime % refreshRate);
			setTimeout(update, updateIn);
		}

		update();
	}
	
	var connected1Set = false;
	var connected2Set = false;
	
	var sMax = 60;
	var mMax = 60;
	var hMax = 24;
	
	function timeConnected1() {
		if(!connected1Set) {
			s1 = Math.floor(Math.random() * sMax);
			m1 = Math.floor(Math.random() * mMax);
			h1 = Math.floor(Math.random() * hMax);
			connected1Set = true;
		}
		
		if(socketAHasConnection) {			
			if(s1 + 1 == sMax) {
				s1 = 0;		
				if(m1 + 1 == mMax) {
					m1 = 0;				
					if(h1 + 1 == hMax) {
						h1 = 0;
					} else {
						++h1;
					}				
				} else {
					++m1;
				}			
			} else {
				++s1;
			}			
		} else {
        	s1 = 0;
        	m1 = 0;
        	h1 = 0;
		}

        $("#timeConnectedA").text(h1 + ":" + pad(m1) + ":" + pad(s1));
		
		setTimeout(timeConnected1, second);
	}
	
	function timeConnected2() {
		if(!connected2Set) {
			s2 = Math.floor(Math.random() * sMax);
			m2 = Math.floor(Math.random() * mMax);
			h2 = Math.floor(Math.random() * hMax);
			connected2Set = true;
		}

		if(socketBHasConnection) {	
			if(s2 + 1 == sMax) {
				s2 = 0;		
				if(m2 + 1 == mMax) {
					m2 = 0;				
					if(h2 + 1 == hMax) {
						h2 = 0;
					} else {
						++h2;
					}				
				} else {
					++m2;
				}			
			} else {
				++s2;
			}	
		} else {
        	s2 = 0;
        	m2 = 0;
        	h2 = 0;
		}

        $("#timeConnectedB").text(h2 + ":" + pad(m2) + ":" + pad(s2));
		
		setTimeout(timeConnected2, second);
	}

	timeConnected1();
	timeConnected2();
	
	
});
