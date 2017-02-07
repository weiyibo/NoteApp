
<div class="modal-content" >
	<div class="modal-header">
		<h3 class="modal-title">Edit Your Note</h3>
	</div>
	<div class="modal-body">
		<form name="createNoteForm" class="form-signin" novalidate>
			
			<div class="form-group">
				<label for="title">Title</label> 
				<input type="text" id="title"
					name="title" class="form-control" ng-model="note.title" required value="{{note.title}}"/>
			</div>
			
			<div class="form-group"
				data-ng-class="{ 'has-error' : createNoteForm.newPassword.$invalid && !createNoteForm.newPassword.$pristine }">
				<label for="labels">Labels</label> 
				<select multiple class="form-control" id="labels" ng-model="labels" required>
					<option ng-repeat="label in labelList">{{label}}</option>
					
			    </select>
			</div>
			<div class="form-group">
			    <label for="content">Note Content</label>
			    <textarea class="form-control" id="content" rows="8" ng-model="note.content" required>{{note.content}}</textarea>
			</div>

			<div class="modal-footer" style="padding: 5px;">
				<button class="btn btn-primary" type="submit"
					style="height: 30px; padding: 4px 12px;" ng-click="editNoteSubmit()">Edit</button>
			</div>
		</form>
	</div>
</div>