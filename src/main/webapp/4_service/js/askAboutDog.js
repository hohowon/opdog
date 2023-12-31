import config from "./config.js";
const { API_KEY } = config;

window.onload = function send() {
  document.getElementById("send").click();
	var audiosend = new Audio('4_service/audio/send.m4a')
	
  // 페이지가 로드될 때 input 값이 설정되어 있다면 비우기
  // 페이지가 로드될 때 'send' 버튼을 자동으로 클릭
  if (document.getElementById("input").value.trim() !== "") {
    document.getElementById("input").value = "";
	audiosend.playbackRate =1.2;
	audiosend.play();
  }


 console.log("imhere~")
document.getElementById("input").addEventListener("keyup", function (event) {
   	var inputValue = document.getElementById("input").value;
	if(inputValue.trim() != ""){
	if (event.keyCode === 13) {
     // 두 번째 클릭 이벤트 핸들러에서의 호출 부분을 삭제
     document.getElementById("send").click();
			document.getElementById("input").value = "";
			audiosend.playbackRate = 1.2;
			audiosend.play();
        }
	 }
    });
  };

//HTML 문서가 완전히 로드되었을 때 지정된 함수를 실행하도록 하는 이벤트 리스너
document.addEventListener("DOMContentLoaded", function () {
  document.getElementById("input").focus();

  document.querySelector("#send").addEventListener("click", async function () {
    document.getElementById("input").focus();
	
    //이 코드는 템플릿 리터럴(template literal)을 사용하여 HTML 코드를 동적으로 생성하는 부분입니다.
    //여기서 생성된 HTML 코드는 사용자의 입력 값을 채팅 창에 표시하는 역할을 합니다.
    var template = `<div class="line"><span class="chat-box mine">${
      document.querySelector("#input").value
    }</span></div>`;
    console.log(template);
    //`` (역따옴표)로 묶인 부분은 템플릿 리터럴입니다.
    //템플릿 리터럴은 문자열을 다루는 새로운 문법으로,
    //여러 줄의 문자열과 변수를 쉽게 표현할 수 있습니다.

    document
      .querySelector(".chat-box-wrap1-2")
      .insertAdjacentHTML("beforeend", template);
    const chatBoxWrap = document.querySelector(".chat-box-wrap1-2");
    chatBoxWrap.scrollTop = chatBoxWrap.scrollHeight;

    const prompt = document.querySelector("#input").value;
    console.log(prompt);
    //const apiKey = config.API_KEY;
    if (prompt == null) {
      prompt = document.querySelector("#input").value;
    }
    try {
      const response = await fetch(
        "https://api.openai.com/v1/chat/completions",
        {
          method: "POST",

          /*HTTP 요청 헤더를 설정한다는 것은 HTTP 요청을 보낼 때, 
			해당 요청에 대한 부가적인 정보를 헤더(Header)에 담아 서버에 전달하는 것을 의미합니다.
			 HTTP 헤더는 요청이나 응답에 대한 메타데이터를 포함하며, 
			이 정보는 클라이언트와 서버 간의 통신을 조절하고 제어하는 데 사용됩니다.*/
          headers: {
            "Content-Type": "application/json",
            /*"Content-Type": "application/xml"은 XML 형식의 데이터를 나타냅니다.
			"Content-Type": "text/plain"은 일반 텍스트 데이터를 나타냅니다.
			"Content-Type": "application/x-www-form-urlencoded"은 웹 폼 데이터를 나타냅니다. */
            Authorization: `Bearer ${API_KEY}`,
          },
          body: JSON.stringify({
            model: "gpt-3.5-turbo-0613",
            /*JavaScript에서 사용되는 객체(Object) 리터럴 문법입니다. 
				이는 객체를 생성하고 그 속성을 설정하는 방식 중 하나입니다. */
            messages: [
              { role: "system", content: "You are a helpful assistant." },
              { role: "user", content: prompt },
            ],
          }),
        }
      );

      const result = await response.json();
      console.log("API 호출 결과:", result);
	  

      if (result.choices && result.choices.length > 0) {
        const chatgptMessage = result.choices[0].message.content;
        console.log("gpt응답", chatgptMessage);

        // 챗봇 응답 출력
        const assistantMessage = result.choices.find(
          (choice) => choice.message.role === "assistant"
        ).message.content;

        var assistantTemplate = `<div class="line"><span class="chat-box">${assistantMessage}</span></div>`;
        document
          .querySelector(".chat-box-wrap1-2")
          .insertAdjacentHTML("beforeend", assistantTemplate);
		var audioreceive = new Audio('4_service/audio/receive.m4a');
		audioreceive.playbackRate = 1.2;
		audioreceive.play();
        //자동 스크롤!s
        const chatBoxWrap = document.querySelector(".chat-box-wrap1-2");
        chatBoxWrap.scrollTop = chatBoxWrap.scrollHeight;
      } else {
        console.log("API 응답에 choices가 없습니다.");
      }
    } catch (error) {
      console.error("API 호출 중 오류:", error);
      // 오류에 대한 추가 처리를 할 수 있습니다.
    }
  });
});
