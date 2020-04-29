'use strict';

// tag::vars[]
const React = require('react'); // <1>
const ReactDOM = require('react-dom'); // <2>
const client = require('./client'); // <3>
const follow = require('./follow');

var root = '/api';

class App extends React.Component { // <1>

	constructor(props) {
		super(props);
		this.state = {deps: [], depL:[], attributes: [], links: {}};
	}

	loadFromServer() {
		follow(client, root, ["deps"]
		).then(depCollection => {
			return client({
				method: 'GET',
				path: depCollection.entity._links.profile.href,
				headers: {'Accept': 'application/schema+json'}
			}).then(schema => {
				this.schema = schema.entity;
				return depCollection;
			});
		}).done(depCollection => {
			this.setState({
				deps: depCollection.entity._embedded.deps,
				attributes: Object.keys(this.schema.properties),
				links: depCollection.entity._links});
		});
	}

	componentDidMount() { // <2>
		/*client({method: 'GET', path: '/api/deps'}).done(response => {
			this.setState({deps: response.entity._embedded.deps});
		});*/
		this.loadFromServer();

	}


	onCreate(newDep) {
		follow(client, root, ['depLs']).then(depCollection => {
			return client({
				method: 'POST',
				path: depCollection.entity._links.self.href,
				entity: newDep,
				headers: {'Content-Type': 'application/json'}
			})
		}).done(response => {
			return follow(client, root, ["depLs"]);
		});
	}

	render() { // <3>
		return (
			<div>
				<CreateDialog attributes={this.state.attributes} onCreate={this.onCreate}/>
				 <DepList deps={this.state.deps} />
				<DepList deps={this.state.deps} />
			</div>
		)
	}
}
// end::app[]

// tag::employee-list[]

class DepList extends React.Component {
	render() {
		const deps = this.props.deps.map(dep =>
			<Dep key={dep._links.self.href} dep={dep}/>
		);
		return (
			<table>
				<tbody>
				<tr>
					<th>Id</th>
					<th>Start date</th>
					<th>End date</th>
					<th>Comments</th>
					<th>Location</th>
					<th>Release</th>
					<th>Environment</th>
				</tr>
				{deps}
				</tbody>
			</table>
		)
	}
}

class Dep extends React.Component {

	constructor(props){
		super(props);
		this.state = {location: [], release:[], environment: [], tasks:[]}
	}

	componentDidMount() {

		this.setState({location: this.fetchData(this.props.dep._links.location.href)});
		//this.setState({release: this.fetchData(this.props.dep._links.release.href)});
		//this.setState({environment: this.fetchData(this.props.dep._links.environment.href)});

		fetch(this.props.dep._links.release.href)
			.then(res => res.json())
			.then(
				(result) => {
					this.setState({
						release: result
					});
				},
				(error) => {
					this.setState({
						error
					});
				}
			);
		fetch(this.props.dep._links.environment.href)
			.then(res => res.json())
			.then(
				(result) => {
					this.setState({
						environment: result
					});
				},
				(error) => {
					this.setState({
						error
					});
				}
			);
		fetch(this.props.dep._links.environment.href)
			.then(res => res.json())
			.then(
				(result) => {
					this.setState({
						environment: result
					});
				},
				(error) => {
					this.setState({
						error
					});
				}
			);
		fetch(this.props.dep._links.tasks.href)
			.then(res => res.json())
			.then(
				(result) => {
					//this.setState({
					//	tasks: result
					//});
					this.setState({tasks: result._embedded.depTasks});

				},
				(error) => {
					this.setState({
						error
					});
				}
			);


	}



	fetchData(link){
		console.log("link: " + link);
		fetch(link)
			.then(res => res.json())
			.then(
				(result) => {
					return result;
				},
				(error) => {
					return error;
				}
			);
	};

	render(){
		const taskArray = this.state.tasks.map((singleTask) => {
			return (
				<p key={singleTask.short_description}>{singleTask.short_description}</p>
			);
		});
		return(
			<tr>
				<td>{this.props.dep.id}</td>
				<td>{this.props.dep.start_date}</td>
				<td>{this.props.dep.end_date}</td>
				<td>{this.props.dep.comments}</td>

				<td>{this.state.release.release}</td>
				<td>{this.state.environment.name}</td>
				<td>{taskArray}</td>
			</tr>

		);
	}
}

class CreateDialog extends React.Component {

	constructor(props) {
		super(props);
		this.handleSubmit = this.handleSubmit.bind(this);
	}

	handleSubmit(e) {
		e.preventDefault();
		const newDep = {};
		this.props.attributes.forEach(attribute => {
			newDep[attribute] = ReactDOM.findDOMNode(this.refs[attribute]).value.trim();
		});
		this.props.onCreate(newDep);

		// clear out the dialog's inputs
		this.props.attributes.forEach(attribute => {
			ReactDOM.findDOMNode(this.refs[attribute]).value = '';
		});

		// Navigate away from the dialog to hide it.
		window.location = "#";
	}

	render() {
		const inputs = this.props.attributes.map(attribute =>
			<p key={attribute}>
				<input type="text" placeholder={attribute} ref={attribute} className="field"/>
			</p>
		);

		return (
			<div>
				<a href="#createDep">Create</a>

				<div id="createDep" className="modalDialog">
					<div>
						<a href="#" title="Close" className="close">X</a>

						<h2>Create new Dep</h2>

						<form>
							{inputs}
							<button onClick={this.handleSubmit}>Create</button>
						</form>
					</div>
				</div>
			</div>
		)
	}

}


// tag::render[]
ReactDOM.render(
	<App />,
	document.getElementById('react')
)
