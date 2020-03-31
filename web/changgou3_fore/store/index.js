//定义方法
export const mutations = {
    setData(state, obj ){     //抽取成公共方法
      //user , obj.key
      //xxx , obj.value
      state[obj.key] = obj.value
    }
  }

  //外部调用
// this.$store.commit('setUser', 'xxx' )