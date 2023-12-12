function checkForm() {
  // 이미지 파일이 선택되었는지 확인합니다.
  if (document.getElementById("fileInput").files.length === 0) {
    alert("이미지 파일을 선택하세요.");
    document.getElementById("fileInput").focus();
    return false;
  }
  
  // 제목 입력값을 얻어옵니다.
  var titleValue = document.getElementById("title").value;
	
  // 제목이 공백 또는 띄어쓰기로만 이루어져 있는 경우를 확인합니다.
  if (!titleValue.trim()) {
    alert("제목을 입력하세요.");
    document.getElementById("title").focus();
    return false;
  }

  // 내용 입력값을 얻어옵니다.
  var txtValue = document.getElementById("txt").value;

  // 내용이 공백 또는 띄어쓰기로만 이루어져 있는 경우를 확인합니다.
  if (!txtValue.trim()) {
    alert("내용을 입력하세요.");
    document.getElementById("txt").focus();
    return false;
  }

  // 모든 입력이 정상이면 등록 페이지로 이동합니다.
 
  	return true;
 	
}


