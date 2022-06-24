//現在の天気を取得
var API_KEY = 'd30875cfe39c9051933628199bc70315';
var defaultCity = 'Tokyo';
function currentWeather(cons) {
	$.ajax({
		url: '//api.openweathermap.org/data/2.5/weather?q=' + defaultCity + ',jp&units=metric&appid=' + API_KEY,
		dataType: 'json',
		type: 'GET'
	})
		.done(function(data) {
			getWeatherData(data);
			createDate(city.date);
			getDiscription(city.description);
			getCloth(city.temp,cons);
			getIcon(city.description);
			domWeatherWrite();
		})
		.fail(function(data) {
			console.log('現在の天気を取得出来ませんでした。')
		});
}

var city = {
	name: '',
	date: '',
	time: '',
	weather: '',
	description: '',
	temp: '',
	tempMin: '',
	tempMax: '',
	feelsLike: '',
	cloudsAll: '',
};

var current = {
	day: '',
	month: '',
	date: '',
	hours: '',
	minitutes: '',
	time: '',
	timeText: '',
}

//データ格納
function getWeatherData(data) {
	(data.name) ? city.name = data.name.toUpperCase() : city.name;
	city.description = data.weather[0].description;
	city.date = new Date(data.dt * 1000);
	city.temp = Math.round(data.main.temp);
	city.tempMin = Math.round(data.main.temp_min);
	city.tempMax = Math.round(data.main.temp_max);
	city.feelsLike = Math.round(data.main.feels_like);
	city.cloudsAll = Math.round(data.clouds.all);
}

//日付&時間取得
function createDate(date) {
	current.day = date;
	current.month = current.day.getMonth() + 1;
	current.date = current.month + '/' + current.day.getDate();
	current.hours = current.day.getHours();
	current.minitutes = ('0' + current.day.getMinutes()).slice(-2);
	current.time = current.hours + ':' + current.minitutes;
	current.timeText = current.date + ' ' + current.time;
}

var UNIT = {
	TEMP: '°',
	PRESSURE: 'hPa',
}
//DOM要素に描写
function domWeatherWrite() {
	$('#city-name').html(city.name);
	$('#weather-temp').html(city.temp + UNIT.TEMP);
	$('#tempMin').html(city.tempMin + UNIT.TEMP);
	$('#tempMax').html(city.tempMax + UNIT.TEMP);
	$('#feelsLike').html(city.feelsLike + UNIT.TEMP);
	$('#weather-date').html(current.timeText);
	//$('.detail-list').css('display', 'flex');
}

//天気情報分岐
function getDiscription(disc) {
	switch (disc) {
		case 'clear sky':
			return $('#weather-discription').html('快晴');
			break;
		case 'few clouds':
			return $('#weather-discription').html('くもり（雲少なめ）');
			break;
		case 'scattered clouds':
			return $('#weather-discription').html('くもり（雲ふつう）');
			break;
		case 'broken clouds':
			return $('#weather-discription').html('くもり（雲多め）');
			break;
		case 'overcast clouds':
			return $('#weather-discription').html('くもり（雲多め）');
			break;
		case 'light intensity shower rain':
			return $('#weather-discription').html('小雨のにわか雨');
			break;
		case 'shower rain':
			return $('#weather-discription').html('にわか雨');
			break;
		case 'heavy intensity shower rain':
			return $('#weather-discription').html('大雨のにわか雨');
			break;
		case 'light rain':
			return $('#weather-discription').html('小雨');
			break;
		case 'moderate rain':
			return $('#weather-discription').html('雨');
			break;
		case 'heavy intensity rain':
			return $('#weather-discription').html('大雨');
			break;
		case 'very heavy rain':
			return $('#weather-discription').html('激しい大雨');
			break;
		case 'rain':
			return $('#weather-discription').html('雨');
			break;
		case 'thunderstorm':
			return $('#weather-discription').html('雷雨');
			break;
		case 'snow':
			return $('#weather-discription').html('雪');
			break;
		case 'mist':
			return $('#weather-discription').html('靄');
			break;
		case 'tornado':
			return $('#weather-discription').html('強風');
			break;
		default:
			return disc;
	}
}

function getCloth(temp,cons) {
var ctemp=0;
if (cons === "寒がり") {
	ctemp = -2;
} else if (cons === "暑がり") {
	ctemp = 2;
} else if (cons === "どちらでもない") {
    ctemp = 0;
}

	if (city.temp + ctemp <= 0) {
		$('#weather-cloth').html('冬服＋コート・アウター＋手袋・マフラー');
	} else if (city.temp+ ctemp <= 10) {
		$('#weather-cloth').html('冬服＋コート・アウター');
	} else if (city.temp+ ctemp <= 15) {
		$('#weather-cloth').html('春用コート・セーター');
	} else if (city.temp+ ctemp <= 20) {
		$('#weather-cloth').html('薄手のジャケット・カーディガン');
	} else if (city.temp+ ctemp <= 25) {
		$('#weather-cloth').html('長袖・半袖＋羽織るもの');
	} else if (city.temp+ ctemp >= 26) {
		$('#weather-cloth').html('半袖・ノースリーブ');
	}

	return temp;
}

//天気情報分岐
function getIcon(disc) {
	var icon = document.getElementById("weather-icon");
	switch (disc) {
		case 'clear sky':
			icon.src = "img/01d.png";
			break;
		case 'few clouds':
			icon.src = "img/03d.png";
			break;
		case 'scattered clouds':
			icon.src = "img/03d.png";
			break;
		case 'broken clouds':
			icon.src = "img/03d.png";
			break;
		case 'overcast clouds':
			icon.src = "img/03d.png";
			break;
		case 'light intensity shower rain':
			icon.src = "img/10d.png";
			break;
		case 'shower rain':
			icon.src = "img/10d.png";
			break;
		case 'heavy intensity shower rain':
			icon.src = "img/10d.png";
			break;
		case 'light rain':
			icon.src = "img/10d.png";
			break;
		case 'moderate rain':
			icon.src = "img/10d.png";
			break;
		case 'heavy intensity rain':
			icon.src = "img/10d.png";
			break;
		case 'very heavy rain':
			icon.src = "img/10d.png";
			break;
		case 'rain':
			icon.src = "img/10d.png";
			break;
		case 'thunderstorm':
			icon.src = "img/11d.png";
			break;
		case 'snow':
			icon.src = "img/13d.png";
			break;
		case 'mist':
			icon.src = "img/50d.png";
			break;
		case 'tornado':
			icon.src = "img/50d.png";
			break;
		default:
			return disc;
	}
}


function weatherInit(cons) {
	currentWeather(cons);
	//threeWeather();
}


