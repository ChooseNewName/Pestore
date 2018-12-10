<template>
	<div id="add" >
		<el-form  label-width="80px" >
			<el-form-item label="宠物名称">
				<el-input v-model="pet.pName"></el-input>
			</el-form-item>
			<el-form-item label="价格">
				<el-input type="number" v-model.number="pet.pPrice"></el-input>
			</el-form-item>
			<el-form-item label="类型">
				<el-select v-model="pet.categoryId" placeholder="请选择类型" >
					<el-option v-for="c in categorys" :value="c.cId" :key="c.cId" :label="c.type"></el-option>
				</el-select>
			</el-form-item>
			<el-form-item label="标签">
				<el-select v-model="pet.tId" placeholder="请选择标签">
					<el-option v-for="t in tags" :value="t.tId" :key="t.tId" :label="t.tag"></el-option>
				</el-select>
			</el-form-item>
			<el-form-item label="状态">
				<el-select v-model="pet.pStatus" placeholder="请选择状态">
					<el-option label="出售" value="出售"></el-option>
					<el-option label="缺货" value="缺货"></el-option>
					<el-option label="待定" value="待定"></el-option>
				</el-select>
			</el-form-item>
			<el-form-item>
				<el-button type="primary" @click="onSubmit">立即添加</el-button>
				<el-button>取消</el-button>
			</el-form-item>
		</el-form>
	</div>
</template>

<script>
	var addPet = {
		name: 'add',
		props: ['categorys','tags'],
		data() {
			return {
				pet: {
					'pName': '',
					'pPrice': '',
					'categoryId':'',
					'tId':'',
					'pStatus':''
				}
			}
		},
		methods: {
			onSubmit() {
				alert("我是："+this.pet.pName+"，价格："+
				this.pet.pPrice+"，类型："+this.pet.categoryId+
				",标签："+this.pet.tId+"，状态："+this.pet.pStatus);
				
				fetch("http://localhost:8080/list",{
					method:'post',
					headers:{
						'Content-Type':'application/json'
					}
				}).then(data => {
					if(data == 0){
						
					}
					location.reload();
				});
					
				
				
				
			}
		}
		
	}

	export default addPet;
</script>

<style>

</style>
