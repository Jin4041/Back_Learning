//삭제 기능
const deleteButton=document.getElementById('delete-btn');

if(deleteButton){
    deleteButton.addEventListener('click',event=>{
        let id=document.getElementById('article-id').value;
        fetch(`/api/articles/${id}`,{
            method:'DELETE'
        })
            .then(()=>{
                alert('삭제가 완료되었습니다.');
                location.replace('/articles');
            });
    });
}

//수정
//id가 modify-btn인 엘리멘트 조회
const modifyButton=document.getElementById('modify-btn');

if(modifyButton){   //클릭 이벤트 감지 시
    modifyButton.addEventListener('click',event=>{
        let params=new URLSearchParams(location.search);
        let id=params.get('id');
        fetch(`/api/articles/${id}`,{
            method:'PUT',
            headers:{
                "Content-Type": "application/json",
            },
            body: JSON.stringify({
                title: document.getElementById('title').value,
                content: document.getElementById('content').value
            })
    })
    .then(()=>{
            alert('수정이 완료되었습니다.');
            location.replace(`/articles/${id}`);
        });
    });
}

//생성
const createButton=document.getElementById('create-btn');

if(createButton){
    createButton.addEventListener("click",(event)=>{
        let id=document.getElementById('article-id').value;
        fetch("/api/articles",{
            method:'POST',
            headers:{
                "Content-Type": "application/json",
            },
            body: JSON.stringify({
                title: document.getElementById('title').value,
                content: document.getElementById('content').value
            })
        }).then(()=>{
                alert('등록 완료되었습니다.');
                location.replace('/articles');
            });
    });
}

//이전 글, 다음 글 이동 버튼 클릭 시 해당 글이 없다면 버튼이 숨겨지도록 함 -- 추후 업데이트