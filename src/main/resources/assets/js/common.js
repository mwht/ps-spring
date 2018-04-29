function resp(ev) { // called upon window size change
	if(ev) {
		var width = ev.target.innerWidth;
		if(width > 900) { // lg - large
			//console.log("lg");
			$("ul.no-menu > .menu-item").removeClass("menu-hidden");
			$("#menu-trigger").addClass("menu-hidden");
			$(".menu-bar > ul.no-menu").css("width","40%");
			$(".column").css("width","50%"); // 2-column layout
			$(".resp-menu").css("display","none");
			// -- menu.html --
			$(".menu-list").css("width","20%");
			$(".menu-list").css("position","fixed");
			$(".menu-list li").css("display","list-item");
			$(".menu-list li").css("width","initial");
			
			$(".menu-list ul").css("padding-top","initial");
			$(".menu-list ul").css("padding-bottom","initial");
			
			$(".menu-list-filler").css("display","initial");
			
			$(".menu-content").css("width","75%");
			$(".menu-content-img").css("width","40%");
			
			$(".menu-content-section table").css("float","right");
			$("body").css("font-size","16px");
			$(".menu-brand-img").css("display","block");
			//$(".menu-list").css("height",$("#content").height()+"px");
		}
		else if(width <= 900) { // md - medium
			//console.log("md");
			$("ul.no-menu > .menu-item").addClass("menu-hidden");
			$("#menu-trigger").removeClass("menu-hidden");
			$(".menu-bar > ul.no-menu").css("width","6%");
			$(".column").css("width","100%"); // single column
			if($(".resp-menu").hasClass("down")) $(".resp-menu").css("display","block");
			else $(".resp-menu").css("display","none");
			// -- menu.html --
			$(".menu-list").css("width","100%");
			$(".menu-list").css("position","relative");
			$(".menu-list li").css("display","inline-block");
			$(".menu-list li").css("width","24%");
			$(".menu-list ul").css("padding-top","15px");
			$(".menu-list ul").css("padding-bottom","15px");
			$(".menu-list").css("height","initial");
			
			$(".menu-list-filler").css("display","none");
			
			$(".menu-content").css("width","100%");
			$(".menu-content-img").css("width","100%");
			
			//$(".menu-content-section table").css("float","initial");
			$("body").css("font-size","12px");
			$(".menu-brand-img").css("display","none");
		}
		
		if(width <= 520) {
			$("body").css("font-size","10px"); // use as a ultimate resort
		}
		
		$("iframe").each( function() {
			var width = $( this ).parent().width();
			if(width > 900) {
				$( this ).width( width*0.8 );
				$( this ).css("margin-left",(width*0.1)+"px");
			} else {
				$( this ).width( width);
				$( this ).css("margin-left","0");				
			}
		});
	}
}

function getCurrentDate() {
	var month = new Array("stycznia","lutego","marca","kwietnia","maja","czerwca","lipca","sierpnia","września","października","listopada","grudnia");
	var zegar = new Date();
	return zegar.getDate() + " " + month[zegar.getMonth()] + " " + (zegar.getYear()>=1900 ? zegar.getYear() : zegar.getYear()+1900);
}

$(document).ready(function() {
	var fakeEv = new Object();
	fakeEv.target = new Object();
	fakeEv.target.innerWidth = window.innerWidth;
	$("#container").css("width","80%");
	resp(fakeEv);
	$(".menu-content > h2").html("Menu na dzień " + getCurrentDate());
	$(window).resize(resp);
	$("#menu-button").click(function() {
		if($(".resp-menu").css("display") == "none") {
			$(".resp-menu").stop().slideDown();
			$(".resp-menu").removeClass("up");
			$(".resp-menu").addClass("down");
		}
		else {
			$(".resp-menu").stop().slideUp();
			$(".resp-menu").removeClass("down");
			$(".resp-menu").addClass("up");
		}
	});
	$(".menu-content-img").click(function(ev) {
		$("#menu-overlay").css("display","block").stop().animate({opacity:1},600,function() {
			$("#menu-gallery").css("background","url("+ev.target.src+") no-repeat center center");
			$("#menu-gallery").stop().animate({opacity:1},600);
		});
	});

	$("#menu-overlay").click(function() {
		$("#menu-overlay").stop().animate({opacity:0},600,function() {
			$("#menu-overlay").css("display","none");
			$("#menu-gallery").css("background","");
			$("#menu-gallery").css("opacity","0");
		});
	});
});