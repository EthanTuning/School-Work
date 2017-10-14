$(document).ready(init);

function init() {

    $("#submitButton").click(submit);
}

function submit() {

    clear();
    
    var dicApiURL = 'https://od-api.oxforddictionaries.com:443/api/v1/entries/';
    var anagramApiURL = 'http://www.anagramica.com/all/:';

    var proxy = 'https://cors-anywhere.herokuapp.com/';

    getData(proxy + dicApiURL, 'en', 'def');
    getData(proxy + dicApiURL, 'en', 'translations=zu');
    getData(proxy + dicApiURL, 'en', 'translations=es');
    getData(proxy + dicApiURL, 'en', 'translations=ro');
    getData(proxy + dicApiURL, 'en', 'translations=de');
    getData(proxy + dicApiURL, 'en', 'synonyms;antonyms');
    getData(proxy + anagramApiURL, 'en', 'anagram');
}

function getData(APIurl, srcLang, dataType) {

    var finalURL;
    var word = getWord();

    if (dataType == 'def')
        finalURL = APIurl + srcLang + '/' + word;
    if (dataType == 'anagram')
        finalURL = APIurl + word;
    if (dataType == 'synonyms;antonyms' || dataType == 'translations=zu' || dataType == 'translations=es' || dataType == 'translations=de' || dataType == 'translations=ro')
        finalURL = APIurl + srcLang + '/' + word + '/' + dataType;

    $.ajaxSetup({
        headers: {
            "Accept": "application/json",
            "app_id": "17489009",
            "app_key": "375d3d75953a33c07b83f203886b55c5"
        }
    });

    $.getJSON(finalURL, function (data) {
        console.log(dataType);
        console.log(data);
        formatData(data, dataType);
    });
}

function getWord() {

    var word = $('#input').val();
    return word;
}

function formatData(data, dataType) {
    
    if (dataType == 'def')
        $('#defParagraph').append(data.results[0].lexicalEntries[0].entries[0].senses[0].definitions[0].toString());

    if (dataType == 'translations=zu' || dataType == 'translations=es' || dataType == 'translations=de' || dataType == 'translations=ro')
        $('#transParagraph').append(data.results[0].lexicalEntries[0].entries[0].senses[0].translations[0].text.toString()+"<br></br>");

    if (dataType == 'synonyms;antonyms') {
        
        var synData = data.results[0].lexicalEntries[0].entries[0].senses[0].synonyms;
        var synonyms = parseJSONarray(synData);
        
        var anData = data.results[0].lexicalEntries[0].entries[0].senses[0].antonyms;
        var antonyms = parseJSONarray(anData);
        
        $('#synParagraph').append(synonyms);
        $('#anParagraph').append(antonyms);
    }

    if (dataType == 'anagram')
        $('#anagram').append(data.all.toString());
}

function clear() {
    $('#defParagraph').empty();
    $('#transParagraph').empty();
    $('#synParagraph').empty();
    $('#anParagraph').empty();
    $('#anagram').empty();
}

function parseJSONarray(data) {
    
    var str='';
    
    data.map(function(id) {
        str += id.text+"<br></br>";
    });
    return str;
}
