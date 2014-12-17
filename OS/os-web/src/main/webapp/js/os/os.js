var OSystem=OSystem||{};
OSystem.Class = function() {
    var len = arguments.length;
    var P = arguments[0];
    var F = arguments[len-1];

    var C = typeof F.initialize == "function" ?
        F.initialize :
        function(){ P.prototype.initialize.apply(this, arguments); };

    if (len > 1) {
        var newArgs = [C, P].concat(
                Array.prototype.slice.call(arguments).slice(1, len-1), F);
        OSystem.inherit.apply(null, newArgs);
    } else {
        C.prototype = F;
    }
    return C;
};
OSystem.inherit = function(C, P) {
   var F = function() {};
   F.prototype = P.prototype;
   C.prototype = new F;
   var i, l, o;
   for(i=2, l=arguments.length; i<l; i++) {
       o = arguments[i];
       if(typeof o === "function") {
           o = o.prototype;
       }
       OSystem.Util.extend(C.prototype, o);
   }
};
OSystem.Util=OSystem.Util||{};
OSystem.Util.extend = function(destination, source) {
    destination = destination || {};
    if (source) {
        for (var property in source) {
            var value = source[property];
            if (value !== undefined) {
                destination[property] = value;
            }
        }

        var sourceIsEvt = typeof window.Event == "function"
                          && source instanceof window.Event;

        if (!sourceIsEvt
           && source.hasOwnProperty && source.hasOwnProperty("toString")) {
            destination.toString = source.toString;
        }
    }
    return destination;
};

OSystem.Manager=OSystem.Manager||{};
OSystem.Manager.UrlManager=OSystem.Class({
	initialize:function(){},
	getUrl:function(visitUrl,paramsSerialize){
		return visitUrl+paramsSerialize;
	},
	getLocationPath:function(){
		return window.location.pathname;
	},
	getContextPath:function(){
		var result=$($("script[data-contextpath]")[0]).data("contextpath");
		if(!result){
			var pathName = document.location.pathname;
			var index = pathName.substr(1).indexOf("/");
			result = pathName.substr(0,index+1);
		}
	    return result;
	}
});
OSystem.Manager.PageManager=OSystem.Class(OSystem.Manager.UrlManager,{
	initialize:function(){
		contextPath=this.getContextPath();
	},
	contextPath:null,
	loadPage:function(uri,target){
		var url=contextPath+uri;
		if(target instanceof Window){
			target.load(url);
		}else{
			$.ajax({
				url:url,
				dataType:"html",
				type:"get",
				success:function(data){
					var html=$(data);
					target.html(html);
				}
			});
		}
	}
});
OSystem.Manager.JsManager=OSystem.Class({
	initialize:function(){},
	loadJs:function(uri){}
});
