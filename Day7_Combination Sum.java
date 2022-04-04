class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result=new ArrayList<List<Integer>>();
        calculate(result,new ArrayList(),0,candidates,0,target);
        return result;
    }
    
    public void calculate(List<List<Integer>> result, List<Integer> list,int i, int[] candidates, int sum, int target){
        if(sum==target){
            result.add(new ArrayList<Integer>(list));
            return;
        }
        if(i>=candidates.length || sum>target){
            return;
        }
        
        list.add(candidates[i]);
        calculate(result,list,i,candidates,sum+candidates[i],target);
        list.remove(list.size()-1);
        calculate(result,list,i+1,candidates,sum,target);
            
    }
}