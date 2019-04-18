$(function() {
  $("#accordion").accordion();
  $("input").checkboxradio();
  $("button").button();
  $(".modal").dialog({
    autoOpen: false,
    modal: true,
    buttons: {
      확인: complete,
      취소: cancel,
    },
  });
});

// 확인하면 주문 완료하기
function complete() {
  var bread = $("#bread").text();
  var topping = $("#topping").text();
  var veggie = $("#veggie").text();
  var sauce = $("#sauce").text();
  var set = $("#set").text();
  alert("주문이 완료되었습니다");
  $(this).dialog("close");
  writeRecord(bread, topping, veggie, sauce, set);
}

// 주문 완료하면 주문 내역에 기록하기
function writeRecord(bread, topping, veggie, sauce, set) {
  var order = `${bread} 빵에 토핑은 ${topping}이(가) 추가되고 야채는 ${veggie}이(가) 들어가고 ${sauce} 소스를 뿌렸고 ${set}이(가) 추가되었습니다`;
  $(".order").append(order);
}

function cancel() {
  $(".modal").dialog("close");
}

// 버튼 누르면 다이얼로그가 나오게
function showDialog() {
  const breadList = document.querySelector(".bread");
  const radio = breadList.getElementsByTagName("input");
  const topList = document.querySelector(".topping");
  const topping = topList.getElementsByTagName("input");
  const vegList = document.querySelector(".veggie");
  const veget = vegList.getElementsByTagName("input");
  const sauceList = document.querySelector(".sauce");
  const sauce = sauceList.getElementsByTagName("input");
  const setList = document.querySelector(".set");
  const set = setList.getElementsByTagName("input");

  let bread = "";
  let toparray = [];
  let vegarray = [];
  let saucearray = [];
  let setarray = [];
  for (var input of radio) {
    if (input.checked) {
      bread = input.value;
    }
  }

  for (var input of topping) {
    if (input.checked) {
      toparray.push(input.value);
    }
  }
  for (var input of veget) {
    if (input.checked) {
      vegarray.push(input.value);
    }
  }
  for (var input of sauce) {
    if (input.checked) {
      saucearray.push(input.value);
    }
  }

  for (var input of set) {
    if (input.checked) {
      setarray.push(input.value);
    }
  }

  $("#bread").text(bread);
  $("#topping").text(toparray);
  $("#veggie").text(vegarray);
  $("#sauce").text(saucearray);
  $("#set").text(setarray);
  $(".modal").dialog({
    autoOpen: true,
  });
}

function init() {
  const button = document.getElementById("button");
  button.addEventListener("click", showDialog);
}

init();
