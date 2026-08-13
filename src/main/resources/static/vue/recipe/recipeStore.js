// Pinia라는 라이브러리 안에서 defineStore라는 도구만 딱 꺼내 쓴다 => CDN 방식으로 피니아 불러오기
const {defineStore}=Pinia
//store가 처음 시작할 때 가지고 있을 기본값들을 미리 정리
const initialState=()=>({
	list:[],
	curpage:1,
	totalpage:0,
	startPage:0,
	endPage:0,
	count:0,
	// 상세보기와 괸련된 데이터
	no:0,
	detail:{},
	mList:[],
	iList:[]
})
// 모든 관리는 useRecipeStore에 저장해서 관리한다
const useRecipeStore=defineStore('recipe_list',{
	// defineStore => 공유변수 만들기
	state:initialState,
	getters:{
		// 공통적으로 사용하는 데이터 들어가는 부분
		range:(state)=>{
			const arr =[]
			for(let i=state.startPage;i<=state.endPage;i++)
				{
					arr.push(i)
				}
				return arr
		}
	},
	actions:{
		async recipeListData(){
			const res=await api.get('/recipe/list_vue',{
				params:{
			       page:this.curpage
				}
			})
			console.log(res.data)
			this.setPageData(res.data)
		},
		setPageData(data)
		{
			// initialState 이 안에 값들 전부 적는다
			this.list=data.list
			this.curpage=data.pages[0]
			this.totalpage=data.pages[1]
			this.startPage=data.pages[2]
			this.endPage=data.pages[3]
			this.count = data.count
		},
		move(page){ 
			this.curpage=page
			this.recipeListData()
			// 평상시 html 파일에 작성하던 걸 함수화 시킴
			
		}, // 레시피 상세보기
		async recipeDetailData(){
			const res=await api.get('/recipe/detail_vue',{
				params:{
					no:this.no
				}
			})
			console.log(res.data)
			this.detail=res.data.vo
			this.mList=res.data.mList
			this.iList=res.data.iList
			
			
		}
		
		
	}
	
})