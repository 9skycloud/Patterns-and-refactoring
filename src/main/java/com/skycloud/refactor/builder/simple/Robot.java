package com.skycloud.refactor.builder.simple;

public class Robot implements AbstractRobotBuilder {

	/* (non-Javadoc)
	 * @see com.skycloud.refactor.builder.simple.AbstractRobotBuilder#makeHead()
	 */
	@Override
	public void makeHead(){
		//制作头型
		makeHeadStyle();
		//制作眼睛，安装摄像头
		makeEye();
		//制作控制芯片
		makeCpu();
		//制作嘴巴
		makeMouse();
		//制作鼻子
		makeNose();
	}
	
	/* (non-Javadoc)
	 * @see com.skycloud.refactor.builder.simple.AbstractRobotBuilder#makeLeg()
	 */
	@Override
	public void makeLeg(){
		//制作腿
		makeSingleLeg();
		//制作脚
		makeFoot();
		//制作脚趾
		makeToe();
		//制作行走联动装置
		makeLinkPage();
	}
	
	/* (non-Javadoc)
	 * @see com.skycloud.refactor.builder.simple.AbstractRobotBuilder#makeBody()
	 */
	@Override
	public void makeBody(){
		//制作胸
		makeChest();
		//制作胳膊
		makeArms();
		//安装电池
		makeBattery();
		//制作骨骼
		makeBones();
		
	}
	
	/* (non-Javadoc)
	 * @see com.skycloud.refactor.builder.simple.AbstractRobotBuilder#makeNose()
	 */
	@Override
	public void makeNose() {
		// TODO Auto-generated method stub
		System.out.println("安装牛鼻子");
	}

	/* (non-Javadoc)
	 * @see com.skycloud.refactor.builder.simple.AbstractRobotBuilder#makeMouse()
	 */
	@Override
	public void makeMouse() {
		// TODO Auto-generated method stub
		System.out.println("安装小嘴");
	}

	/* (non-Javadoc)
	 * @see com.skycloud.refactor.builder.simple.AbstractRobotBuilder#makeCpu()
	 */
	@Override
	public void makeCpu() {
		// TODO Auto-generated method stub
		System.out.println("安装核心控制模式");
	}

	/* (non-Javadoc)
	 * @see com.skycloud.refactor.builder.simple.AbstractRobotBuilder#makeEye()
	 */
	@Override
	public void makeEye() {
		// TODO Auto-generated method stub
		System.out.println("安装8000像素摄影头");
	}

	/* (non-Javadoc)
	 * @see com.skycloud.refactor.builder.simple.AbstractRobotBuilder#makeHeadStyle()
	 */
	@Override
	public void makeHeadStyle() {
		// TODO Auto-generated method stub
		System.out.println("安装人形脸盘");
	}

	/* (non-Javadoc)
	 * @see com.skycloud.refactor.builder.simple.AbstractRobotBuilder#makeBones()
	 */
	@Override
	public void makeBones() {
		// TODO Auto-generated method stub
		System.out.println("安装人形结构");
	}

	/* (non-Javadoc)
	 * @see com.skycloud.refactor.builder.simple.AbstractRobotBuilder#makeBattery()
	 */
	@Override
	public void makeBattery() {
		// TODO Auto-generated method stub
		System.out.println("高压力电池");
	}

	/* (non-Javadoc)
	 * @see com.skycloud.refactor.builder.simple.AbstractRobotBuilder#makeArms()
	 */
	@Override
	public void makeArms() {
		// TODO Auto-generated method stub
		System.out.println("人形手臂");
	}

	/* (non-Javadoc)
	 * @see com.skycloud.refactor.builder.simple.AbstractRobotBuilder#makeChest()
	 */
	@Override
	public void makeChest() {
		// TODO Auto-generated method stub
		System.out.println("安装人形");
	}


	/* (non-Javadoc)
	 * @see com.skycloud.refactor.builder.simple.AbstractRobotBuilder#makeLinkPage()
	 */
	@Override
	public void makeLinkPage() {
		// TODO Auto-generated method stub
		System.out.println("安装最新联动设备");
	}

	/* (non-Javadoc)
	 * @see com.skycloud.refactor.builder.simple.AbstractRobotBuilder#makeToe()
	 */
	@Override
	public void makeToe() {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see com.skycloud.refactor.builder.simple.AbstractRobotBuilder#makeFoot()
	 */
	@Override
	public void makeFoot() {
		// TODO Auto-generated method stub
		System.out.println("安装人形脚");
	}

	/* (non-Javadoc)
	 * @see com.skycloud.refactor.builder.simple.AbstractRobotBuilder#makeSingleLeg()
	 */
	@Override
	public void makeSingleLeg() {
		// TODO Auto-generated method stub
		
	}
	
}
