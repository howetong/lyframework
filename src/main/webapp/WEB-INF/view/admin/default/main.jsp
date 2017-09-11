<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="commons/commons.jsp" %>

<div class="page-header">
	<h1>
		控制台
		<small>
			<i class="ace-icon fa fa-angle-double-right"></i>
			概览 &amp;统计
		</small>
	</h1>
</div><!-- /.page-header -->
						
<div class="row">
	<div class="col-xs-12">
		<!-- PAGE CONTENT BEGINS -->
		<div class="alert alert-block alert-success">
			<button type="button" class="close" data-dismiss="alert">
				<i class="ace-icon fa fa-times"></i>
			</button>

			<strong class="green">
				Java开发平台框架 - 蜻蜓v1.0
			</strong>
			可能还有一些BUG,功能还可以更多。框架不断在开发，一个星期至少更新一次。
		</div>

		<div class="row">
			<div class="space-6"></div>
		
				<div class="col-sm-7 infobox-container">
					<!-- #section:pages/dashboard.infobox -->
					<div class="infobox infobox-green">
						<div class="infobox-icon">
							<i class="ace-icon fa fa-comments"></i>
						</div>
		
						<div class="infobox-data">
							<span class="infobox-data-number">32</span>
							<div class="infobox-content">评论</div>
						</div>
		
						<!-- #section:pages/dashboard.infobox.stat -->
						<div class="stat stat-success">8%</div>
		
						<!-- /section:pages/dashboard.infobox.stat -->
					</div>
		
					<div class="infobox infobox-blue">
						<div class="infobox-icon">
							<i class="ace-icon fa fa-twitter"></i>
						</div>
		
						<div class="infobox-data">
							<span class="infobox-data-number">11</span>
							<div class="infobox-content">新粉丝</div>
						</div>
		
						<div class="badge badge-success">
							+32%
							<i class="ace-icon fa fa-arrow-up"></i>
						</div>
					</div>
		
					<div class="infobox infobox-pink">
						<div class="infobox-icon">
							<i class="ace-icon fa fa-shopping-cart"></i>
						</div>
			
						<div class="infobox-data">
							<span class="infobox-data-number">8</span>
							<div class="infobox-content">新订单</div>
						</div>
						<div class="stat stat-important">4%</div>
					</div>
		
					<div class="infobox infobox-red">
						<div class="infobox-icon">
							<i class="ace-icon fa fa-flask"></i>
						</div>
		
						<div class="infobox-data">
							<span class="infobox-data-number">7</span>
							<div class="infobox-content">调查</div>
						</div>
					</div>
		
					<div class="infobox infobox-orange2">
						<!-- #section:pages/dashboard.infobox.sparkline -->
						<div class="infobox-chart">
							<span class="sparkline" data-values="196,128,202,177,154,94,100,170,224"></span>
						</div>
		
						<!-- /section:pages/dashboard.infobox.sparkline -->
						<div class="infobox-data">
							<span class="infobox-data-number">6,251</span>
							<div class="infobox-content">浏览量</div>
						</div>
		
						<div class="badge badge-success">
							7.2%
							<i class="ace-icon fa fa-arrow-up"></i>
						</div>
					</div>
		
					<div class="infobox infobox-blue2">
						<div class="infobox-progress">
							<!-- #section:pages/dashboard.infobox.easypiechart -->
							<div class="easy-pie-chart percentage" data-percent="42" data-size="46">
								<span class="percent">42</span>%
							</div>
		
							<!-- /section:pages/dashboard.infobox.easypiechart -->
						</div>
		
						<div class="infobox-data">
							<span class="infobox-text">硬盘使用</span>
		
							<div class="infobox-content">
								<span class="bigger-110">~</span>
								剩余 58GB 
							</div>
						</div>
					</div>
		
					<!-- /section:pages/dashboard.infobox -->
					<div class="space-6"></div>
		
					<!-- #section:pages/dashboard.infobox.dark -->
					<div class="infobox infobox-green infobox-small infobox-dark">
						<div class="infobox-progress">
							<!-- #section:pages/dashboard.infobox.easypiechart -->
							<div class="easy-pie-chart percentage" data-percent="61" data-size="39">
								<span class="percent">61</span>%
							</div>
		
							<!-- /section:pages/dashboard.infobox.easypiechart -->
						</div>
		
						<div class="infobox-data">
							<div class="infobox-content">任务</div>
							<div class="infobox-content">完成</div>
						</div>
					</div>
		
					<div class="infobox infobox-blue infobox-small infobox-dark">
						<!-- #section:pages/dashboard.infobox.sparkline -->
						<div class="infobox-chart">
							<span class="sparkline" data-values="3,4,2,3,4,4,2,2"></span>
						</div>
		
						<!-- /section:pages/dashboard.infobox.sparkline -->
						<div class="infobox-data">
							<div class="infobox-content">盈余</div>
							<div class="infobox-content">$32,000</div>
						</div>
					</div>
		
					<div class="infobox infobox-grey infobox-small infobox-dark">
						<div class="infobox-icon">
							<i class="ace-icon fa fa-download"></i>
						</div>
		
						<div class="infobox-data">
							<div class="infobox-content">下载次数</div>
							<div class="infobox-content">1,205</div>
						</div>
					</div>
		
					<!-- /section:pages/dashboard.infobox.dark -->
				</div>
		
				<div class="vspace-12-sm"></div>
		
				<div class="col-sm-5">
				<div class="widget-box">
					<div class="widget-header widget-header-flat widget-header-small">
						<h5 class="widget-title">
							<i class="ace-icon fa fa-signal"></i>
							访问来源
						</h5>
		
						<div class="widget-toolbar no-border">
							<div class="inline dropdown-hover">
								<button class="btn btn-minier btn-primary">
									本周
									<i class="ace-icon fa fa-angle-down icon-on-right bigger-110"></i>
								</button>
		
								<ul class="dropdown-menu dropdown-menu-right dropdown-125 dropdown-lighter dropdown-close dropdown-caret">
									<li class="active">
										<a href="#" class="blue">
											<i class="ace-icon fa fa-caret-right bigger-110">&nbsp;</i>
											本周
										</a>
									</li>
		
									<li>
										<a href="#">
											<i class="ace-icon fa fa-caret-right bigger-110 invisible">&nbsp;</i>
											上周
										</a>
									</li>
		
									<li>
										<a href="#">
											<i class="ace-icon fa fa-caret-right bigger-110 invisible">&nbsp;</i>
											本月
										</a>
									</li>
		
									<li>
										<a href="#">
											<i class="ace-icon fa fa-caret-right bigger-110 invisible">&nbsp;</i>
											上月
										</a>
									</li>
								</ul>
							</div>
						</div>
					</div>
		
					<div class="widget-body">
						<div class="widget-main">
							<!-- #section:plugins/charts.flotchart -->
							<div id="piechart-placeholder"></div>
			
							<!-- /section:plugins/charts.flotchart -->
							<div class="hr hr8 hr-double"></div>
			
							<div class="clearfix">
								<!-- #section:custom/extra.grid -->
								<div class="grid3">
									<span class="grey">
										<i class="ace-icon fa fa-facebook-square fa-2x blue"></i>
										&nbsp; 脸书
									</span>
									<h4 class="bigger pull-right">1,255</h4>
								</div>
			
								<div class="grid3">
									<span class="grey">
										<i class="ace-icon fa fa-twitter-square fa-2x purple"></i>
										&nbsp; 推特
									</span>
									<h4 class="bigger pull-right">941</h4>
								</div>
			
								<div class="grid3">
									<span class="grey">
										<i class="ace-icon fa fa-pinterest-square fa-2x red"></i>
										&nbsp; 微博
									</span>
									<h4 class="bigger pull-right">1,050</h4>
								</div>
			
								<!-- /section:custom/extra.grid -->
							</div>
						</div><!-- /.widget-main -->
					</div><!-- /.widget-body -->
				</div><!-- /.widget-box -->
			</div><!-- /.col -->
		</div><!-- /.row -->

		<!-- #section:custom/extra.hr -->
		<div class="hr hr32 hr-dotted"></div>

		<!-- /section:custom/extra.hr -->

		<div class="hr hr32 hr-dotted"></div>

		<div class="row">
			<div class="col-sm-5">
				<div class="widget-box transparent">
					<div class="widget-header widget-header-flat">
						<h4 class="widget-title lighter">
							<i class="ace-icon fa fa-star orange"></i>
							热门域名
						</h4>

						<div class="widget-toolbar">
							<a href="#" data-action="collapse">
								<i class="ace-icon fa fa-chevron-up"></i>
							</a>
						</div>
					</div>
		
					<div class="widget-body">
						<div class="widget-main no-padding">
							<table class="table table-bordered table-striped">
								<thead class="thin-border-bottom">
									<tr>
										<th>
											<i class="ace-icon fa fa-caret-right blue"></i>名称
										</th>

										<th>
											<i class="ace-icon fa fa-caret-right blue"></i>价格
										</th>

										<th class="hidden-480">
											<i class="ace-icon fa fa-caret-right blue"></i>状态
										</th>
									</tr>
								</thead>

								<tbody>
									<tr>
										<td>internet.com</td>

										<td>
											<small>
												<s class="red">$29.99</s>
											</small>
											<b class="green">$19.99</b>
										</td>

										<td class="hidden-480">
											<span class="label label-info arrowed-right arrowed-in">在售</span>
										</td>
									</tr>

									<tr>
										<td>online.com</td>

										<td>
											<b class="blue">$16.45</b>
										</td>

										<td class="hidden-480">
											<span class="label label-success arrowed-in arrowed-in-right">可用</span>
										</td>
									</tr>

									<tr>
										<td>newnet.com</td>

										<td>
											<b class="blue">$15.00</b>
										</td>

										<td class="hidden-480">
											<span class="label label-danger arrowed">待定</span>
										</td>
									</tr>

									<tr>
										<td>web.com</td>

										<td>
											<small>
												<s class="red">$24.99</s>
											</small>
											<b class="green">$19.95</b>
										</td>

										<td class="hidden-480">
											<span class="label arrowed">
												<s>缺货</s>
											</span>
										</td>
									</tr>

									<tr>
										<td>domain.com</td>

										<td>
											<b class="blue">$12.00</b>
										</td>

										<td class="hidden-480">
											<span class="label label-warning arrowed arrowed-right">售完</span>
										</td>
									</tr>
								</tbody>
							</table>
						</div><!-- /.widget-main -->
					</div><!-- /.widget-body -->
				</div><!-- /.widget-box -->
			</div><!-- /.col -->
		</div>
		<div class="row">
			<div class="col-sm-6">
				<div class="widget-box transparent" id="recent-box">
					<div class="widget-header">
						<h4 class="widget-title lighter smaller">
							<i class="ace-icon fa fa-rss orange"></i>最近
						</h4>

						<div class="widget-toolbar no-border">
							<ul class="nav nav-tabs" id="recent-tab">
								<li class="active">
									<a data-toggle="tab" href="#task-tab">任务</a>
								</li>

								<li>
									<a data-toggle="tab" href="#member-tab">会员</a>
								</li>

								<li>
									<a data-toggle="tab" href="#comment-tab">评论</a>
								</li>
							</ul>
						</div>
					</div>

					<div class="widget-body">
						<div class="widget-main padding-4">
							<div class="tab-content padding-8">
								<div id="task-tab" class="tab-pane active">
									<h4 class="smaller lighter green">
										<i class="ace-icon fa fa-list"></i>
										可拖拽排序列表
									</h4>

									<!-- #section:pages/dashboard.tasks -->
									<ul id="tasks" class="item-list">
										<li class="item-orange clearfix">
											<label class="inline">
												<input type="checkbox" class="ace" />
												<span class="lbl"> 解答客户问题</span>
											</label>

											<div class="pull-right easy-pie-chart percentage" data-size="30" data-color="#ECCB71" data-percent="42">
												<span class="percent">42</span>%
											</div>
										</li>

										<li class="item-red clearfix">
											<label class="inline">
												<input type="checkbox" class="ace" />
												<span class="lbl"> BUG修复</span>
											</label>

											<!-- #section:custom/extra.action-buttons -->
											<div class="pull-right action-buttons">
												<a href="#" class="blue">
													<i class="ace-icon fa fa-pencil bigger-130"></i>
												</a>

												<span class="vbar"></span>

												<a href="#" class="red">
													<i class="ace-icon fa fa-trash-o bigger-130"></i>
												</a>

												<span class="vbar"></span>

												<a href="#" class="green">
													<i class="ace-icon fa fa-flag bigger-130"></i>
												</a>
											</div>

											<!-- /section:custom/extra.action-buttons -->
										</li>

										<li class="item-default clearfix">
											<label class="inline">
												<input type="checkbox" class="ace" />
												<span class="lbl"> 增加新特性</span>
											</label>

											<!-- #section:elements.dropdown.hover -->
											<div class="pull-right pos-rel dropdown-hover">
												<button class="btn btn-minier bigger btn-primary">
													<i class="ace-icon fa fa-cog icon-only bigger-120"></i>
												</button>

												<ul class="dropdown-menu dropdown-only-icon dropdown-yellow dropdown-caret dropdown-close dropdown-menu-right">
													<li>
														<a href="#" class="tooltip-success" data-rel="tooltip" title="Mark&nbsp;as&nbsp;done">
															<span class="green">
																<i class="ace-icon fa fa-check bigger-110"></i>
															</span>
														</a>
													</li>

													<li>
														<a href="#" class="tooltip-error" data-rel="tooltip" title="Delete">
															<span class="red">
																<i class="ace-icon fa fa-trash-o bigger-110"></i>
															</span>
														</a>
													</li>
												</ul>
											</div>

											<!-- /section:elements.dropdown.hover -->
										</li>

										<li class="item-blue clearfix">
											<label class="inline">
												<input type="checkbox" class="ace" />
												<span class="lbl"> 更新框架脚本</span>
											</label>
										</li>

										<li class="item-grey clearfix">
											<label class="inline">
												<input type="checkbox" class="ace" />
												<span class="lbl"> 增加新皮肤</span>
											</label>
										</li>

										<li class="item-green clearfix">
											<label class="inline">
												<input type="checkbox" class="ace" />
												<span class="lbl"> 升级服务端</span>
											</label>
										</li>

										<li class="item-pink clearfix">
											<label class="inline">
												<input type="checkbox" class="ace" />
												<span class="lbl">清理系统垃圾</span>
											</label>
										</li>
									</ul>

									<!-- /section:pages/dashboard.tasks -->
								</div>

								<div id="member-tab" class="tab-pane">
									<!-- #section:pages/dashboard.members -->
									<div class="clearfix">
										<div class="itemdiv memberdiv">
											<div class="user">
												<img alt="Bob Doe's avatar" src="<%=basePath%>s/assets/avatars/user.jpg" />
											</div>

											<div class="body">
												<div class="name">
													<a href="#">Bob Doe</a>
												</div>

												<div class="time">
													<i class="ace-icon fa fa-clock-o"></i>
													<span class="green">20 min</span>
												</div>

												<div>
													<span class="label label-warning label-sm">待定</span>

													<div class="inline position-relative">
														<button class="btn btn-minier btn-yellow btn-no-border dropdown-toggle" data-toggle="dropdown" data-position="auto">
															<i class="ace-icon fa fa-angle-down icon-only bigger-120"></i>
														</button>

														<ul class="dropdown-menu dropdown-only-icon dropdown-yellow dropdown-menu-right dropdown-caret dropdown-close">
															<li>
																<a href="#" class="tooltip-success" data-rel="tooltip" title="同意">
																	<span class="green">
																		<i class="ace-icon fa fa-check bigger-110"></i>
																	</span>
																</a>
															</li>

															<li>
																<a href="#" class="tooltip-warning" data-rel="tooltip" title="拒绝">
																	<span class="orange">
																		<i class="ace-icon fa fa-times bigger-110"></i>
																	</span>
																</a>
															</li>

															<li>
																<a href="#" class="tooltip-error" data-rel="tooltip" title="删除">
																	<span class="red">
																		<i class="ace-icon fa fa-trash-o bigger-110"></i>
																	</span>
																</a>
															</li>
														</ul>
													</div>
												</div>
											</div>
										</div>

										<div class="itemdiv memberdiv">
											<div class="user">
												<img alt="Joe Doe's avatar" src="<%=basePath%>s/assets/avatars/avatar2.png" />
											</div>

											<div class="body">
												<div class="name">
													<a href="#">Joe Doe</a>
												</div>

												<div class="time">
													<i class="ace-icon fa fa-clock-o"></i>
													<span class="green">1 hour</span>
												</div>

												<div>
													<span class="label label-warning label-sm">待定</span>

													<div class="inline position-relative">
														<button class="btn btn-minier btn-yellow btn-no-border dropdown-toggle" data-toggle="dropdown" data-position="auto">
															<i class="ace-icon fa fa-angle-down icon-only bigger-120"></i>
														</button>

														<ul class="dropdown-menu dropdown-only-icon dropdown-yellow dropdown-menu-right dropdown-caret dropdown-close">
															<li>
																<a href="#" class="tooltip-success" data-rel="tooltip" title="同意">
																	<span class="green">
																		<i class="ace-icon fa fa-check bigger-110"></i>
																	</span>
																</a>
															</li>

															<li>
																<a href="#" class="tooltip-warning" data-rel="tooltip" title="拒绝">
																	<span class="orange">
																		<i class="ace-icon fa fa-times bigger-110"></i>
																	</span>
																</a>
															</li>

															<li>
																<a href="#" class="tooltip-error" data-rel="tooltip" title="删除">
																	<span class="red">
																		<i class="ace-icon fa fa-trash-o bigger-110"></i>
																	</span>
																</a>
															</li>
														</ul>
													</div>
												</div>
											</div>
										</div>

										<div class="itemdiv memberdiv">
											<div class="user">
												<img alt="Jim Doe's avatar" src="<%=basePath%>s/assets/avatars/avatar.png" />
											</div>

											<div class="body">
												<div class="name">
													<a href="#">Jim Doe</a>
												</div>

												<div class="time">
													<i class="ace-icon fa fa-clock-o"></i>
													<span class="green">2 hour</span>
												</div>

												<div>
													<span class="label label-warning label-sm">待定</span>

													<div class="inline position-relative">
														<button class="btn btn-minier btn-yellow btn-no-border dropdown-toggle" data-toggle="dropdown" data-position="auto">
															<i class="ace-icon fa fa-angle-down icon-only bigger-120"></i>
														</button>

														<ul class="dropdown-menu dropdown-only-icon dropdown-yellow dropdown-menu-right dropdown-caret dropdown-close">
															<li>
																<a href="#" class="tooltip-success" data-rel="tooltip" title="同意">
																	<span class="green">
																		<i class="ace-icon fa fa-check bigger-110"></i>
																	</span>
																</a>
															</li>

															<li>
																<a href="#" class="tooltip-warning" data-rel="tooltip" title="拒绝">
																	<span class="orange">
																		<i class="ace-icon fa fa-times bigger-110"></i>
																	</span>
																</a>
															</li>

															<li>
																<a href="#" class="tooltip-error" data-rel="tooltip" title="删除">
																	<span class="red">
																		<i class="ace-icon fa fa-trash-o bigger-110"></i>
																	</span>
																</a>
															</li>
														</ul>
													</div>
												</div>
											</div>
										</div>

										<div class="itemdiv memberdiv">
											<div class="user">
												<img alt="Alex Doe's avatar" src="<%=basePath%>s/assets/avatars/avatar5.png" />
											</div>

											<div class="body">
												<div class="name">
													<a href="#">Alex Doe</a>
												</div>

												<div class="time">
													<i class="ace-icon fa fa-clock-o"></i>
													<span class="green">3 hour</span>
												</div>

												<div>
													<span class="label label-danger label-sm">锁定</span>
												</div>
											</div>
										</div>

										<div class="itemdiv memberdiv">
											<div class="user">
												<img alt="Bob Doe's avatar" src="<%=basePath%>s/assets/avatars/avatar2.png" />
											</div>

											<div class="body">
												<div class="name">
													<a href="#">Bob Doe</a>
												</div>

												<div class="time">
													<i class="ace-icon fa fa-clock-o"></i>
													<span class="green">6 hour</span>
												</div>

												<div>
													<span class="label label-success label-sm arrowed-in">同意</span>
												</div>
											</div>
										</div>

										<div class="itemdiv memberdiv">
											<div class="user">
												<img alt="Susan's avatar" src="<%=basePath%>s/assets/avatars/avatar3.png" />
											</div>

											<div class="body">
												<div class="name">
													<a href="#">Susan</a>
												</div>

												<div class="time">
													<i class="ace-icon fa fa-clock-o"></i>
													<span class="green">yesterday</span>
												</div>

												<div>
													<span class="label label-success label-sm arrowed-in">同意</span>
												</div>
											</div>
										</div>

										<div class="itemdiv memberdiv">
											<div class="user">
												<img alt="Phil Doe's avatar" src="<%=basePath%>s/assets/avatars/avatar4.png" />
											</div>

											<div class="body">
												<div class="name">
													<a href="#">Phil Doe</a>
												</div>

												<div class="time">
													<i class="ace-icon fa fa-clock-o"></i>
													<span class="green">2 days ago</span>
												</div>

												<div>
													<span class="label label-info label-sm arrowed-in arrowed-in-right">在线</span>
												</div>
											</div>
										</div>

										<div class="itemdiv memberdiv">
											<div class="user">
												<img alt="Alexa Doe's avatar" src="<%=basePath%>s/assets/avatars/avatar1.png" />
											</div>

											<div class="body">
												<div class="name">
													<a href="#">Alexa Doe</a>
												</div>

												<div class="time">
													<i class="ace-icon fa fa-clock-o"></i>
													<span class="green">3 days ago</span>
												</div>

												<div>
													<span class="label label-success label-sm arrowed-in">同意</span>
												</div>
											</div>
										</div>
									</div>

									<div class="space-4"></div>

									<div class="center">
										<i class="ace-icon fa fa-users fa-2x green middle"></i>

										&nbsp;
										<a href="#" class="btn btn-sm btn-white btn-info">
											查看所有会员 &nbsp;
											<i class="ace-icon fa fa-arrow-right"></i>
										</a>
									</div>

									<div class="hr hr-double hr8"></div>

									<!-- /section:pages/dashboard.members -->
								</div><!-- /.#member-tab -->

								<div id="comment-tab" class="tab-pane">
									<!-- #section:pages/dashboard.comments -->
									<div class="comments">
										<div class="itemdiv commentdiv">
											<div class="user">
												<img alt="Bob Doe's Avatar" src="<%=basePath%>s/assets/avatars/avatar.png" />
											</div>

											<div class="body">
												<div class="name">
													<a href="#">Bob Doe</a>
												</div>

												<div class="time">
													<i class="ace-icon fa fa-clock-o"></i>
													<span class="green">6 min</span>
												</div>

												<div class="text">
													<i class="ace-icon fa fa-quote-left"></i>
													Bootstrap是简洁、直观、强悍的前端开发框架，让web开发更迅速、简单。 &hellip;
												</div>
											</div>

											<div class="tools">
												<div class="inline position-relative">
													<button class="btn btn-minier bigger btn-yellow dropdown-toggle" data-toggle="dropdown">
														<i class="ace-icon fa fa-angle-down icon-only bigger-120"></i>
													</button>

													<ul class="dropdown-menu dropdown-only-icon dropdown-yellow dropdown-menu-right dropdown-caret dropdown-close">
														<li>
															<a href="#" class="tooltip-success" data-rel="tooltip" title="同意">
																<span class="green">
																	<i class="ace-icon fa fa-check bigger-110"></i>
																</span>
															</a>
														</li>

														<li>
															<a href="#" class="tooltip-warning" data-rel="tooltip" title="拒绝">
																<span class="orange">
																	<i class="ace-icon fa fa-times bigger-110"></i>
																</span>
															</a>
														</li>

														<li>
															<a href="#" class="tooltip-error" data-rel="tooltip" title="删除">
																<span class="red">
																	<i class="ace-icon fa fa-trash-o bigger-110"></i>
																</span>
															</a>
														</li>
													</ul>
												</div>
											</div>
										</div>

										<div class="itemdiv commentdiv">
											<div class="user">
												<img alt="Jennifer's Avatar" src="<%=basePath%>s/assets/avatars/avatar1.png" />
											</div>

											<div class="body">
												<div class="name">
													<a href="#">Jennifer</a>
												</div>

												<div class="time">
													<i class="ace-icon fa fa-clock-o"></i>
													<span class="blue">15 min</span>
												</div>

												<div class="text">
													<i class="ace-icon fa fa-quote-left"></i>
													Bootstrap 是最受欢迎的HTML,CSS和JS框架，用于开发响应式布局，移动设备优先的WEB项目。 &hellip;
												</div>
											</div>

											<div class="tools">
												<div class="action-buttons bigger-125">
													<a href="#">
														<i class="ace-icon fa fa-pencil blue"></i>
													</a>

													<a href="#">
														<i class="ace-icon fa fa-trash-o red"></i>
													</a>
												</div>
											</div>
										</div>

										<div class="itemdiv commentdiv">
											<div class="user">
												<img alt="Joe's Avatar" src="<%=basePath%>s/assets/avatars/avatar2.png" />
											</div>

											<div class="body">
												<div class="name">
													<a href="#">Joe</a>
												</div>

												<div class="time">
													<i class="ace-icon fa fa-clock-o"></i>
													<span class="orange">22 min</span>
												</div>

												<div class="text">
													<i class="ace-icon fa fa-quote-left"></i>
													BootStrap让前端开发更快速、简单，所有设备都适配，所有项目都适用。 &hellip;
												</div>
											</div>

											<div class="tools">
												<div class="action-buttons bigger-125">
													<a href="#">
														<i class="ace-icon fa fa-pencil blue"></i>
													</a>

													<a href="#">
														<i class="ace-icon fa fa-trash-o red"></i>
													</a>
												</div>
											</div>
										</div>

										<div class="itemdiv commentdiv">
											<div class="user">
												<img alt="Rita's Avatar" src="<%=basePath%>s/assets/avatars/avatar3.png" />
											</div>

											<div class="body">
												<div class="name">
													<a href="#">Rita</a>
												</div>

												<div class="time">
													<i class="ace-icon fa fa-clock-o"></i>
													<span class="red">50 min</span>
												</div>

												<div class="text">
													<i class="ace-icon fa fa-quote-left"></i>
													Lorem ipsum dolor sit amet, consectetur adipiscing elit. Quisque commodo massa sed ipsum porttitor facilisis &hellip;
												</div>
											</div>

											<div class="tools">
												<div class="action-buttons bigger-125">
													<a href="#">
														<i class="ace-icon fa fa-pencil blue"></i>
													</a>

													<a href="#">
														<i class="ace-icon fa fa-trash-o red"></i>
													</a>
												</div>
											</div>
										</div>
									</div>

									<div class="hr hr8"></div>

									<div class="center">
										<i class="ace-icon fa fa-comments-o fa-2x green middle"></i>

										&nbsp;
										<a href="#" class="btn btn-sm btn-white btn-info">
											查看所有评论 &nbsp;
											<i class="ace-icon fa fa-arrow-right"></i>
										</a>
									</div>

									<div class="hr hr-double hr8"></div>

									<!-- /section:pages/dashboard.comments -->
								</div>
							</div>
						</div><!-- /.widget-main -->
					</div><!-- /.widget-body -->
				</div><!-- /.widget-box -->
			</div><!-- /.col -->
		
			<div class="col-sm-6">
				<div class="widget-box">
					<div class="widget-header">
						<h4 class="widget-title lighter smaller">
							<i class="ace-icon fa fa-comment blue"></i>
							Conversation
						</h4>
					</div>

					<div class="widget-body">
						<div class="widget-main no-padding">
							<!-- #section:pages/dashboard.conversations -->
							<div class="dialogs">
								<div class="itemdiv dialogdiv">
									<div class="user">
										<img alt="Alexa's Avatar" src="<%=basePath%>s/assets/avatars/avatar1.png" />
									</div>

									<div class="body">
										<div class="time">
											<i class="ace-icon fa fa-clock-o"></i>
											<span class="green">4 sec</span>
										</div>

										<div class="name">
											<a href="#">Alexa</a>
										</div>
										<div class="text">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Quisque commodo massa sed ipsum porttitor facilisis.</div>

										<div class="tools">
											<a href="#" class="btn btn-minier btn-info">
												<i class="icon-only ace-icon fa fa-share"></i>
											</a>
										</div>
									</div>
								</div>

								<div class="itemdiv dialogdiv">
									<div class="user">
										<img alt="John's Avatar" src="<%=basePath%>s/assets/avatars/avatar.png" />
									</div>

									<div class="body">
										<div class="time">
											<i class="ace-icon fa fa-clock-o"></i>
											<span class="blue">38 sec</span>
										</div>

										<div class="name">
											<a href="#">John</a>
										</div>
										<div class="text">Raw denim you probably haven&#39;t heard of them jean shorts Austin.</div>

										<div class="tools">
											<a href="#" class="btn btn-minier btn-info">
												<i class="icon-only ace-icon fa fa-share"></i>
											</a>
										</div>
									</div>
								</div>

								<div class="itemdiv dialogdiv">
									<div class="user">
										<img alt="Bob's Avatar" src="<%=basePath%>s/assets/avatars/user.jpg" />
									</div>

									<div class="body">
										<div class="time">
											<i class="ace-icon fa fa-clock-o"></i>
											<span class="orange">2 min</span>
										</div>

										<div class="name">
											<a href="#">Bob</a>
											<span class="label label-info arrowed arrowed-in-right">admin</span>
										</div>
										<div class="text">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Quisque commodo massa sed ipsum porttitor facilisis.</div>

										<div class="tools">
											<a href="#" class="btn btn-minier btn-info">
												<i class="icon-only ace-icon fa fa-share"></i>
											</a>
										</div>
									</div>
								</div>

								<div class="itemdiv dialogdiv">
									<div class="user">
										<img alt="Jim's Avatar" src="<%=basePath%>s/assets/avatars/avatar4.png" />
									</div>

									<div class="body">
										<div class="time">
											<i class="ace-icon fa fa-clock-o"></i>
											<span class="grey">3 min</span>
										</div>

										<div class="name">
											<a href="#">Jim</a>
										</div>
										<div class="text">Raw denim you probably haven&#39;t heard of them jean shorts Austin.</div>

										<div class="tools">
											<a href="#" class="btn btn-minier btn-info">
												<i class="icon-only ace-icon fa fa-share"></i>
											</a>
										</div>
									</div>
								</div>

								<div class="itemdiv dialogdiv">
									<div class="user">
										<img alt="Alexa's Avatar" src="<%=basePath%>s/assets/avatars/avatar1.png" />
									</div>

									<div class="body">
										<div class="time">
											<i class="ace-icon fa fa-clock-o"></i>
											<span class="green">4 min</span>
										</div>

										<div class="name">
											<a href="#">Alexa</a>
										</div>
										<div class="text">Lorem ipsum dolor sit amet, consectetur adipiscing elit.</div>

										<div class="tools">
											<a href="#" class="btn btn-minier btn-info">
												<i class="icon-only ace-icon fa fa-share"></i>
											</a>
										</div>
									</div>
								</div>
							</div>

							<!-- /section:pages/dashboard.conversations -->
							<form>
								<div class="form-actions">
									<div class="input-group">
										<input placeholder="在此输入信息 ..." type="text" class="form-control" name="message" />
										<span class="input-group-btn">
											<button class="btn btn-sm btn-info no-radius" type="button">
												<i class="ace-icon fa fa-share"></i>
												发送
											</button>
										</span>
									</div>
								</div>
							</form>
						</div><!-- /.widget-main -->
					</div><!-- /.widget-body -->
				</div><!-- /.widget-box -->
			</div><!-- /.col -->
		</div><!-- /.row -->
		<!-- PAGE CONTENT ENDS -->
	</div><!-- /.col -->
</div><!-- /.row -->

<script src="<%=basePath%>s/assets/js/jquery-ui.custom.js"></script>
<script src="<%=basePath%>s/assets/js/jquery.ui.touch-punch.js"></script>
<script src="<%=basePath%>s/assets/js/jquery.easypiechart.js"></script>
<script src="<%=basePath%>s/assets/js/jquery.sparkline.js"></script>
<script src="<%=basePath%>s/assets/js/flot/jquery.flot.js"></script>
<script src="<%=basePath%>s/assets/js/flot/jquery.flot.pie.js"></script>
<script src="<%=basePath%>s/assets/js/flot/jquery.flot.resize.js"></script>
<script src="<%=basePath%>s/assets/js/activities-serverload.js"></script>
<script src="<%=basePath%>s/assets/js/ace/ace.sidebar-scroll-1.js"></script>

<script type="text/javascript">
<%-- 	var scripts = [null,
    "<%=basePath%>s/assets/js/jquery-ui.custom.js",
    "<%=basePath%>s/assets/js/jquery.ui.touch-punch.js",
    "<%=basePath%>s/assets/js/jquery.easypiechart.js",
    "<%=basePath%>s/assets/js/jquery.sparkline.js",
    "<%=basePath%>s/assets/js/flot/jquery.flot.js",
    "<%=basePath%>s/assets/js/flot/jquery.flot.pie.js",
    "<%=basePath%>s/assets/js/flot/jquery.flot.resize.js",
    "<%=basePath%>s/assets/js/activities-serverload.js",
    "<%=basePath%>s/assets/js/ace/ace.sidebar-scroll-1.js",
    null]; --%>
	$('.easy-pie-chart .percentage').each(function(){
		var $box = $(this).closest('.infobox');
		var barColor = $(this).data('color') || (!$box.hasClass('infobox-dark') ? $box.css('color') : 'rgba(255,255,255,0.95)');
		var trackColor = barColor == 'rgba(255,255,255,0.95)' ? 'rgba(255,255,255,0.25)' : '#E2E2E2';
		var size = parseInt($(this).data('size')) || 50;
		$(this).easyPieChart({
			barColor: barColor,
			trackColor: trackColor,
			scaleColor: false,
			lineCap: 'butt',
			lineWidth: parseInt(size/10),
			animate: ace.vars['old_ie'] ? false : 1000,
			size: size
		});
	})
	$('.sparkline').each(function(){
		var $box = $(this).closest('.infobox');
		var barColor = !$box.hasClass('infobox-dark') ? $box.css('color') : '#FFF';
		$(this).sparkline('html',
			 {
				tagValuesAttribute:'data-values',
				type: 'bar',
				barColor: barColor ,
				chartRangeMin:$(this).data('min') || 0
			 });
	})
	//flot chart resize plugin, somehow manipulates default browser resize event to optimize it!
	//but sometimes it brings up errors with normal resize event handlers
	$.resize.throttleWindow = false;

	var placeholder = $('#piechart-placeholder').css({'width':'90%' , 'min-height':'150px'});
	var data = [
	{ label: "社交网络",  data: 38.7, color: "#68BC31"},
	{ label: "搜索引擎",  data: 24.5, color: "#2091CF"},
	{ label: "广告活动",  data: 8.2, color: "#AF4E96"},
	{ label: "直接访问",  data: 18.6, color: "#DA5430"},
	{ label: "其他",  data: 10, color: "#FEE074"}
	]
	function drawPieChart(placeholder, data, position) {
		$.plot(placeholder, data, {
			series: {
				pie: {
					show: true,
					tilt:0.8,
					highlight: {
						opacity: 0.25
					},
					stroke: {
						color: '#fff',
						width: 2
					},
					startAngle: 2
				}
			},
			legend: {
				show: true,
				position: position || "ne", 
				labelBoxBorderColor: null,
				margin:[-30,15]
			},
			grid: {
				hoverable: true,
				clickable: true
			}
 		})
	}
 	drawPieChart(placeholder, data);

	/**
	we saved the drawing function and the data to redraw with different position later when switching to RTL mode dynamically
	so that's not needed actually.
	*/
	placeholder.data('chart', data);
	placeholder.data('draw', drawPieChart);


	//pie chart tooltip example
	var $tooltip = $("<div class='tooltip top in'><div class='tooltip-inner'></div></div>").hide().appendTo('body');
	var previousPoint = null;

	placeholder.on('plothover', function (event, pos, item) {
		if(item) {
			if (previousPoint != item.seriesIndex) {
				previousPoint = item.seriesIndex;
				var tip = item.series['label'] + " : " + item.series['percent']+'%';
				$tooltip.show().children(0).text(tip);
			}
			$tooltip.css({top:pos.pageY + 10, left:pos.pageX + 10});
		} else {
			$tooltip.hide();
			previousPoint = null;
		}
	
 	});
	
	
	//Android's default browser somehow is confused when tapping on label which will lead to dragging the task
	//so disable dragging when clicking on label
	var agent = navigator.userAgent.toLowerCase();
	if("ontouchstart" in document && /appletwebkit/.test(agent) && /android/.test(agent)) {
	  $('#tasks').on('touchstart', function(e){
		var li = $(e.target).closest('#tasks li');
		if(li.length == 0)
			return;
		var label = li.find('label.inline').get(0);
		if(label == e.target || $.contains(label, e.target)) 
			e.stopImmediatePropagation() ;
	  });
	}

	$('#tasks').sortable({
		opacity:0.8,
		revert:true,
		forceHelperSize:true,
		placeholder: 'draggable-placeholder',
		forcePlaceholderSize:true,
		tolerance:'pointer',
		stop: function( event, ui ) {
			//just for Chrome!!!! so that dropdowns on items don't appear below other items after being moved
			$(ui.item).css('z-index', 'auto');
		}
		}
	);
	$('#tasks').disableSelection();
	$('#tasks input:checkbox').removeAttr('checked').on('click', function(){
		if(this.checked) $(this).closest('li').addClass('selected');
		else $(this).closest('li').removeClass('selected');
	});


	//show the dropdowns on top or bottom depending on window height and menu position
	$('#task-tab .dropdown-hover').on('mouseenter', function(e) {
		var offset = $(this).offset();

		var $w = $(window)
		if (offset.top > $w.scrollTop() + $w.innerHeight() - 100) 
			$(this).addClass('dropup');
		else $(this).removeClass('dropup');
	});
	
	Index.initCharts();
	
</script>
