/**
 * @license Copyright (c) 2003-2019, CKSource - Frederico Knabben. All rights reserved.
 * For licensing, see https://ckeditor.com/legal/ckeditor-oss-license
 */

CKEDITOR.editorConfig = function( config ) {
	// Define changes to default configuration here. For example:
	// config.language = 'fr';
	// config.uiColor = '#AADC6E';
	config.removePlugins = 'dialog,copy,link,forms,copyformatting,save,paste,about,clipboard,iframe,a11yhelp,flash,templates,'
							+'find,div,template,specialchar,scayt,preview,pastefromword,pagebreak,pagicline,image';
	config.extraPlugins = "codesnippet,simage";
};
