<template>
	<div >
		<!-- 添加组件 -->
		<addpet :tags="tagList" :categorys="categoryList"></addpet>

		<!-- 信息 -->
		<el-table :data="petList" height="250" border style="width: 100%">
			<el-table-column prop="pName" label="宠物名称" width="180">
			</el-table-column>
			<el-table-column prop="pPrice" label="价格" width="180">
			</el-table-column>
			<el-table-column prop="category.type" label="类型">
			</el-table-column>
			<el-table-column prop="tag.tag" label="标签">
			</el-table-column>
			<el-table-column prop="pStatus" label="状态">
			</el-table-column>
			<el-table-column label="修改">
				<el-button type="info" round>信息按钮</el-button>
			</el-table-column>
			<el-table-column label="删除">
				<el-button type="danger" round>危险按钮</el-button>
			</el-table-column>
		</el-table>

	</div>
</template>

<script>
	import addPet from './components/addPet.vue';

	export default {
		name: 'app',
		data() {
			return {
				petList: [],
				categoryList: [],
				tagList: []
			}
		},
		components: {
			addpet: addPet
		},
		created() {
			fetch('http://localhost:8080/list', null)
				.then(resp => resp.json())
				.then(data => {
					//console.log(data.petList);
					//console.log(data.tagList);
					//console.log(data.categoryList);
					this.petList = data.petList;
					this.categoryList = data.categoryList;
					this.tagList = data.tagList;
				});
		}
		
	}
</script>

<style>

</style>
