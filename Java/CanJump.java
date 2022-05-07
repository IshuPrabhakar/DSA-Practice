pakage Java;


class CanJump {

    public boolean canJump(int[] nums) {

        boolean isJumpPossible = false;

        

        int index = 0;

        int lastIndex = nums.length - 1;

        while(index == lastIndex || nums[index] == 0){

            int valueAt = nums[index];

            index = valueAt;

            if(valueAt == nums[lastIndex]){

                isJumpPossible = true;

                break;

            }

        }

        return isJumpPossible;

    }

}
