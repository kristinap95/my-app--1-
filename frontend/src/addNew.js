import { html, css, LitElement } from 'lit';
import "@vaadin/vaadin-text-field";
import "@vaadin/text-area";
import "@vaadin/vaadin-button";
import "@vaadin/vaadin-upload";
import "@vaadin/avatar";
import { UploadBeforeEvent } from '@vaadin/upload';

export class newCardForm extends LitElement {
  static get styles() {
    return css`
    * {
        font-family: inherit;
        line-height: inherit;
    }
    button:first-child {
        all: unset;
    }
    .grid {
        display: grid;
        grid-template-columns: repeat(3, minmax(0, 1fr));
        grid-template-rows: repeat(3, minmax(0, 1fr));
        max-width: 400px;
    }
    .thumbnail {
      place-self: center;
    }
    svg {
        color: rgb(156 163 175);
        width: 3rem;
        height: 3rem;;
    }
    .col-span-2 {
        grid-column: span 2 / span 2;
        align-self: center;
    }
    .col-span-3 {
        grid-column: span 3 / span 3;
    }
    .media {
        display: flex;
        flex-wrap: nowrap;
        flex-direction: column;
        align-items: center;
        justify-content: center;
        margin-top: 0.25rem;
        padding: 1.5rem;
        border: 2px dashed rgb(209 213 219);
        color: rgb(68 64 60);
        background-image: url("");
        background-size: cover;
    }
    .mt-1 {
      margin-top: 1rem;
    }
    .right-coner {
      margin-left: auto;
    }
        `;
  }
  constructor() {
    super();
  }
  printed(e) {
    console.log("YOU ARE HEREEEE", e);
  }
  render() {
    return html`
      <div class="grid">
        <div class="thumbnail">
            <vaadin-avatar id="thumbnail" theme="xlarge"></vaadin-avatar>
        </div>
        <div class="col-span-2">
            <vaadin-text-field id="header" placeholder="Title goes here..."></vaadin-text-field>
            <vaadin-text-field id="subhead" placeholder="Subtitle text"></vaadin-text-field>
        </div>
        <div class="col-span-3">
            <div class="media">
            <vaadin-upload id="media" 
            target="/api/fileupload/" 
            max-files="1" 
            @upload-success="${this.printed}"
            
            ></vaadin-upload>
            </div>
        </div>
        <div class="col-span-3 mt-1">
            <vaadin-text-area id="support" rows="3" placeholder="Supporting text"></vaadin-text-area>
        </div>
        <div class="col-span-3">
            <vaadin-button id="btn1">Action 1</vaadin-button>
            <vaadin-button id="btn2">Action 2</vaadin-button>
        </div>
        <div class="col-span-3 right-coner">
          <vaadin-button id="cancelBtn">Cancel</vaadin-button>
          <vaadin-button id="saveBtn" theme="primary">Save</vaadin-button>
        </div>
    </div>
    `;
  }
}

window.customElements.define('v-card-form', newCardForm);