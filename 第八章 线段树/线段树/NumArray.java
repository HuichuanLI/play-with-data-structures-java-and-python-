
    class NumArray {

        private int [] arr;
        public NumArray(int[] nums) {
            arr = new int[nums.length + 1];
            for(int i=0;i<nums.length;i++){
                arr[i] = arr[i-1] + nums[i-1];
            }
        }

        public int sumRange(int i, int j) {
            return arr[j+1] - arr[i];;
        }
    }

