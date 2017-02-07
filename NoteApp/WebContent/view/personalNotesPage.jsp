
<div class="navbar-wrapper">
<div class="container">
	<nav class="navbar navbar-default navbar-inverse" role="navigation">
		<div class="container-fluid">
			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1">

				<form class="navbar-form navbar-left" role="search" ng-submit="searchNote()">
                    <select class="form-control" ng-init="searchFilter= 'label'" ng-model="searchFilter">
					    <option value="label" selected="selected">Label</option>
					    <option value="title">Title</option>
					    <option value="content">Content</option>
					</select>
                    
					<div class="form-group">
						<input type="text" class="form-control" placeholder="Search" ng-model="searchInput" required>
					</div>
					<button type="submit" class="btn btn-default" ng-disabled="form.$invalid">Search</button>
				</form>
				
				<ul class="nav navbar-nav">
					<li><a href="" ng-click="listAll()">List All Notes</a></li>
				</ul>
				
				<ul class="nav navbar-nav navbar-right">
					<li><a href="#/login">Log out? &nbsp;&nbsp; {{currentUser.username}}</a></li>
				</ul>
			</div>
		</div>
	</nav>
</div>
</div>

<div class="container-wrapper" style="padding-top:100px; padding-bottom:50px">
	<div class="container">
		<div class="page-header">
			<h1>All Notes</h1>
			<p class="lead" align="right"><button class="btn btn-default" ng-click="createNote()">Create New Note</button></p>
		</div>
		<table class="table table-striped table-hover">
			<thead>
				<tr class="bg-success">
					<th>Title</th>
					<th>Author</th>
					<th>Labels</th>
					<th>Contents</th>
					<th>Edit</th>
					<th>Delete</th>
				</tr>
			</thead>
			<tr class="bg-success" ng-repeat="note in noteList">
				<td>{{note.title}}</td>
				<td>{{note.author}}</td>
				<td>
					<span ng-repeat="label in note.labels" >
						<span class="label label-primary">{{label}}</span>
					</span>
				</td>
				<td>{{note.content}}</td>
				<td><button class="btn btn-default" ng-click="editNote($index)" ng-show="'{{note.author}}' == '{{currentUser.username}}'">Edit</button></td>
				<td><button class="btn btn-default" ng-click="deleteNote($index)" ng-show="'{{note.author}}' == '{{currentUser.username}}'">Delete</button></td>
			</tr>
		</table>
	</div>
</div>
